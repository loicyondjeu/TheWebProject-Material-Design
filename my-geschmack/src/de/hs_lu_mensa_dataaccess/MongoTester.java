package de.hs_lu_mensa_dataaccess;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public abstract class MongoTester {

	public static void main(String[] args) {
		
		MongoConnection mongoConn = new MongoConnection();
		MongoDatabase database = mongoConn.getMongoDataBase();
		
		MongoCollection<Document> offers = database.getCollection("Offers");
		MongoCollection<Document> users = database.getCollection("Users");
		
		/**
		 * READ OPERATIONEN
		 */
		
		// Anzahl der Dokumente in einer Collection lesen
		System.out.println(offers.count());
		
		//erste Dokument lesen
		Document myDoc = offers.find().first();
		System.out.println(myDoc.toJson());

		//alle Dokumente lesen
		
		 /* Mit Hilfe des Mongocursors */
		MongoCursor<Document> cursor = users.find().iterator();
		try {
			while (cursor.hasNext())
				System.out.println(cursor.next().toJson());
		} finally {
			cursor.close();
		}
		
		 /* Mit Hilfe des FindIterable */
		FindIterable<Document> cursor2 = users.find();
		while (((Iterator<Document>) cursor2).hasNext()) {
			System.out.println(((Iterator<Document>) cursor2).next());
		}

		 /* Mit Hilfe des Filters Objects für gefilterte Anfragen*/
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
//		 BasicDBObject newDocument = new BasicDBObject();
//		 newDocument.put("clients", 110);
//
//		 BasicDBObject searchQuery = new BasicDBObject().append("hosting", "hostB");
//
//		 collection.updateOne(searchQuery, newDocument);

		/**
		 * NACH JEDER DB-TRANSAKTION DATENBANK VERBINDUNG SCHLIEßEN
		 */
		mongoConn.close();
	}
	
	/**
	 * Diese Methode liefert die Anwendungssteuerung die Information, ob gerade die Datenbank verfügbar ist oder nicht.
	 * @return
	 */
	public static boolean testMongo(){
		MongoConnection mongoConn = new MongoConnection();
		
		try {
			MongoCollection<Document> test = mongoConn.getMongoDataBase().getCollection("test");
			test.find();
		} catch (Exception e) {
			return false;
		}finally {
			mongoConn.close(); //Verbindung zur Datenbank immer schließen !
		}
		
		return true;
	}

}
