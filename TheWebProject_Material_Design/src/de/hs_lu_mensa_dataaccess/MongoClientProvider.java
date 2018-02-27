package de.hs_lu_mensa_dataaccess;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * Diese Klasse liefert eine Instanz eines MongoDB Clients zur Datenbank von Jasmin.
 * Sie abstrahiert deshalb die URI zur Verbindung MongoDB Atlas Server in der Cloud
 * <strong>Die URI muss dann nur hier bei Problemen angepasst werden</strong>
 * @author loicy
 *
 */
public class MongoClientProvider {
	
	MongoClient mongoClient;
	MongoClientURI mongoURI;
	String uri;
	
	public MongoClientProvider(){
		this.uri = "mongodb://TheWebProject:flamongo@"
					+"mensaapp-shard-00-00-dyqy3.mongodb.net:27017,"
					+"mensaapp-shard-00-01-dyqy3.mongodb.net:27017,"
					+"mensaapp-shard-00-02-dyqy3.mongodb.net:27017"
					+"/test?ssl=true&replicaSet=MensaApp-shard-0&authSource=admin";
		this.mongoURI = new MongoClientURI(uri);
		this.mongoClient = new MongoClient(mongoURI);
	}
	
	public MongoClient getMongoClient(){
		return this.mongoClient;
	}

}
