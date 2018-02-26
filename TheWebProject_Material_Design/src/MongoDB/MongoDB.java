package MongoDB;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB {

						@SuppressWarnings("unchecked")
						public static void printAllDocuments(MongoCollection<Document> collection) {
							FindIterable<Document> cursor = collection.find();
							while (((Iterator<DBObject>) cursor).hasNext()) {
								System.out.println(((Iterator<DBObject>) cursor).next());
							}
						}
						public static void insertDummyDocuments(MongoCollection<Document> collection) {
							Document document = new Document();
							document.put("hosting", "hostA");
							document.put("type", "vps");
							document.put("clients", 1000);

							Document document2 = new Document();
							document2.put("hosting", "hostB");
							document2.put("type", "dedicated server");
							document2.put("clients", 100);

							Document document3 = new Document();
							document3.put("hosting", "hostC");
							document3.put("type", "vps");
							document3.put("clients", 900);

							collection.insertOne(document);
							collection.insertOne(document2);
							collection.insertOne(document3);
						}


							public static void main(String[] args) {
								

						try {

							// URI für die Verbindung aufsetzen
							String uri0 = "mongodb://TheWebProject:flamongo@mensaapp-shard-00-00-dyqy3.mongodb.net:27017,mensaapp-shard-00-01-dyqy3.mongodb.net:27017,mensaapp-shard-00-02-dyqy3.mongodb.net:27017/test?ssl=true&replicaSet=MensaApp-shard-0&authSource=admin";
							MongoClientURI uri = new MongoClientURI(uri0);

							// MongoClient für den Zugriff auf die Datenbank
							MongoClient mongoClient = new MongoClient(uri);

							// Datenbank als Java-Objekt erhalten  
							MongoDatabase database = mongoClient.getDatabase("MensaBase");

							// Collections mit Hilfe der Datenbank als Java-Objekte erhalten

							MongoCollection<Document> collection = database.getCollection("test");

							System.out.println(collection.count());

						  System.out.println("Testing 1...no $set");

						  insertDummyDocuments(collection);

						  // find hosting = hostB, and update the clients to 110
						  BasicDBObject newDocument = new BasicDBObject();
						  newDocument.put("clients", 110);

						  BasicDBObject searchQuery = new BasicDBObject().append("hosting", "hostB");

						  collection.updateOne(searchQuery, newDocument);

						  printAllDocuments(collection);

						  System.out.println("\nTesting 1...with $set");

						  insertDummyDocuments(collection);

						  BasicDBObject updateDocument = new BasicDBObject();
						  updateDocument.append("$set", new BasicDBObject().append("clients", 110));

						  BasicDBObject searchQuery2 = new BasicDBObject().append("hosting", "hostB");

						  collection.updateOne(searchQuery2, updateDocument);

						  printAllDocuments(collection);

						  System.out.println("\nTesting 2... with $inc");
						  insertDummyDocuments(collection);
						  // find hosting = hostB and increase it's "clients" value by 99
						  BasicDBObject newDocument2 = new BasicDBObject().append("$inc",
							new BasicDBObject().append("clients", 99));

						  collection.updateOne(new BasicDBObject().append("hosting", "hostB"), newDocument2);

						  printAllDocuments(collection);

						  System.out.println("\nTesting 3... with $multi");

						  insertDummyDocuments(collection);
						  // find type = vps , update all matched documents , clients value to 888
						  BasicDBObject updateQuery = new BasicDBObject();
						  updateQuery.append("$set", new BasicDBObject().append("clients", "888"));

						  BasicDBObject searchQuery3 = new BasicDBObject();
						  searchQuery3.append("type", "vps");

						  collection.updateMany(searchQuery3, updateQuery);
						  // collection.update(searchQuery3, updateQuery, false, true);

						  printAllDocuments(collection);

						  System.out.println("Done");
						  mongoClient.close();

						} catch (MongoException e) {
							e.printStackTrace();
						}

}
}
