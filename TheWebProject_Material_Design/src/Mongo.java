
	import com.mongodb.MongoClient;
	import com.mongodb.MongoClientURI;

	import com.mongodb.client.MongoDatabase;
	import com.mongodb.client.MongoCollection;

	import org.bson.Document;


	import com.mongodb.client.MongoCursor;

	public class Mongo {

		public static void main(String[] args) {

			// Um den Client erstellen zu können, benötigen wir die URI unseres MongoDB
			// Clusters
			// Das Cluster beinhaltet bereits eine REST API

			// URI für die Verbindung aufsetzen
			String uri0 = "mongodb://TheWebProject:flamongo@mensaapp-shard-00-00-dyqy3.mongodb.net:27017,mensaapp-shard-00-01-dyqy3.mongodb.net:27017,mensaapp-shard-00-02-dyqy3.mongodb.net:27017/test?ssl=true&replicaSet=MensaApp-shard-0&authSource=admin";
			MongoClientURI uri = new MongoClientURI(uri0);

			// MongoClient für den Zugriff auf die Datenbank
			MongoClient mongoClient = new MongoClient(uri);

			// Datenbank als Java-Objekt erhalten  
			MongoDatabase database = mongoClient.getDatabase("MensaBase");

			// Collections mit Hilfe der Datenbank als Java-Objekte erhalten

			MongoCollection<Document> offers = database.getCollection("Offers");

			MongoCollection<Document> users = database.getCollection("Users");

			// Ein BSON-Array ist wie eine List
			// Anzahl der Dokumente in einer Collection

			System.out.println(offers.count());

			// Zeigt das erste Dokument innerhalb einer Collection an (komplettes JSON file)
			Document myDoc = offers.find().first();
			System.out.println(myDoc.toJson());

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

			//Schließe den MongoClient
			mongoClient.close();
		}
	}

