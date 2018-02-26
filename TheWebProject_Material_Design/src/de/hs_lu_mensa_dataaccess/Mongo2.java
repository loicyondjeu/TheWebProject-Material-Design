package de.hs_lu_mensa_dataaccess;

import com.mongodb.MongoClient;
	import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

//import pojos.Employee;

import com.mongodb.client.MongoCollection;

	import org.bson.Document;


	import com.mongodb.client.MongoCursor;

	public class Mongo2 {

		public static void insertDocuments(MongoCollection<Document> collection) {
			Document document = new Document();
			document.put("name", "Knusperhuhn");
			document.put("salat", "Salatteller");
			document.put("carbs", 1000);

			Document document2 = new Document();
			document2.put("name", "H�hnersuppe");
			document2.put("vegetarisch", false);
			document2.put("komplement", "Pommes");

			Document document3 = new Document();
			document3.put("name", "Gemueserisotto");
			document3.put("vegetarisch", true);
			document3.put("komplement", "kroketten");

			collection.insertOne(document);
			collection.insertOne(document2);
			collection.insertOne(document3);
		}

		public static void main(String[] args) {

			try {
			// Um den Client erstellen zu k�nnen, ben�tigen wir die URI unseres MongoDB
			// Clusters
			// Das Cluster beinhaltet bereits eine REST API

			// URI f�r die Verbindung aufsetzen
			String uri0 = "mongodb://TheWebProject:flamongo@mensaapp-shard-00-00-dyqy3.mongodb.net:27017,mensaapp-shard-00-01-dyqy3.mongodb.net:27017,mensaapp-shard-00-02-dyqy3.mongodb.net:27017/test?ssl=true&replicaSet=MensaApp-shard-0&authSource=admin";
			MongoClientURI uri = new MongoClientURI(uri0);

			// MongoClient f�r den Zugriff auf die Datenbank
			MongoClient mongoClient = new MongoClient(uri);

			// Datenbank als Java-Objekt erhalten  
			MongoDatabase database = mongoClient.getDatabase("MensaBase");

			// Collections mit Hilfe der Datenbank als Java-Objekte erhalten

			MongoCollection<Document> offers = database.getCollection("Offers");

			MongoCollection<Document> users = database.getCollection("Users");
			
			MongoCollection<Document> test = database.getCollection("test");

			// Ein BSON-Array ist wie eine List
			// Anzahl der Dokumente in einer Collection

			System.out.println("Anzahl Dokumente in offers: " + offers.count());
			System.out.println("Anzahl Dokumente in test: " + test.count());

			//Einuegen der beiden oben genannten Dokumente
			insertDocuments(test);
			
			System.out.println("Anzahl Dokumente in test: " + test.count());
			
			//POJO to JSON 
			
//			Employee employee = new Employee();
//	        employee.setNo(1L);
//	        employee.setName("Deborah Nosh");
//
//
//	       Document doc = new Document("name", employee);
//	       
//	       users.insertOne(doc);
			

			// Zeigt das erste Dokument innerhalb einer Collection an (komplettes JSON file)
			Document myDoc = offers.find().first();
			System.out.println(myDoc);

			// Gibt alle Dokumente innerhalb einer Collection aus
			MongoCursor<Document> cursor = users.find().iterator();
			try {
				while (cursor.hasNext()) {
					System.out.println(cursor.next().toJson());
				}
			} finally {
				cursor.close();
			}
			
			
			// Gibt das erste Dokument bei dem der Wochentag Montag ist
			/* myDoc = collection1.find(eq("wochentag", "Montag")).first();
			System.out.println(myDoc.toJson()); */

			//Schlie�e den MongoClient
			System.out.println("finished");
			mongoClient.close();
			
		}
			catch(MongoException e) {
				e.printStackTrace();
			}
		}
	}

