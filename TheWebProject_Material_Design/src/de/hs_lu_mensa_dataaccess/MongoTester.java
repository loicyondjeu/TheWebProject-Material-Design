package de.hs_lu_mensa_dataaccess;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class MongoTester {

	public static void main(String[] args) {
		System.out.println(new MongoTester().testMongo());
	}
	
	public boolean testMongo(){
		try {
			MongoCollection<Document> test = new MongoConnection().getMongoDataBase().getCollection("test");
			test.find();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
