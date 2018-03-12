package de.hs_lu.mensa.model;

import org.bson.Document;

public interface Persistable {
	
	void initMongo();
	Document toDocument();
	void toObject(Document doc);
	

}
