package de.hs_lu_mensa_dataaccess;

//import com.mongodb.BasicDBObject;
//import com.mongodb.DBObject;
import com.mongodb.MongoClient;
	import com.mongodb.MongoClientURI;

	import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import java.util.Iterator;

import org.bson.Document;


	import com.mongodb.client.MongoCursor;

	public class MongoTest {

		@SuppressWarnings("unchecked")
		public static void main(String[] args) {
			
			String uri0 = "mongodb://TheWebProject:flamongo@mensaapp-shard-00-00-dyqy3.mongodb.net:27017,mensaapp-shard-00-01-dyqy3.mongodb.net:27017,mensaapp-shard-00-02-dyqy3.mongodb.net:27017/test?ssl=true&replicaSet=MensaApp-shard-0&authSource=admin";
			MongoClientURI uri = new MongoClientURI(uri0);
			MongoClient mongoClient = new MongoClient(uri);
			MongoDatabase database = mongoClient.getDatabase("MensaBase");

			MongoCollection<Document> offers = database.getCollection("Offers");
			MongoCollection<Document> users = database.getCollection("Users");

			/**
			 * READ OPERATIONEN
			 */
			
			// Anzahl der Dokumente in einer Collection
			System.out.println(offers.count());
			
			//erste Dokument
			Document myDoc = offers.find().first();
			System.out.println(myDoc.toJson());

			//alle Dokumente
			
			//Mit Mongocursor
			MongoCursor<Document> cursor = users.find().iterator();
			try {
				while (cursor.hasNext())
					System.out.println(cursor.next().toJson());
			} finally {
				cursor.close();
			}
			
			//With FindIterable
			FindIterable<Document> cursor2 = users.find();
			while (((Iterator<Document>) cursor2).hasNext()) {
				System.out.println(((Iterator<Document>) cursor2).next());
			}

			//Mit Filters Object
			myDoc = offers.find(Filters.eq("wochentag", "Montag")).first();
			System.out.println(myDoc.toJson());
			
			
			/**
			 * CREATE OPERATIONEN
			 */
			
			Document document = new Document();
			document.put("hosting", "hostA");
			document.put("type", "vps");
			document.put("clients", 1000);
			
			users.insertOne(document);
			
			/**
			 * UPDATE OPERATIONEN
			 */
//			 BasicDBObject newDocument = new BasicDBObject();
//			 newDocument.put("clients", 110);
//
//			 BasicDBObject searchQuery = new BasicDBObject().append("hosting", "hostB");
//
//			 collection.updateOne(searchQuery, newDocument);

			mongoClient.close();
		}
	}

