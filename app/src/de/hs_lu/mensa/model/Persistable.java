package de.hs_lu.mensa.model;

import org.bson.Document;

/**
 * Alle Klassen die das Interface Persistable implementieren müssen über folgende Eigenschaften verfügen.
 * <ul>
 * 	<li>Eine Verbindung mit MongoDB zu realisieren</li>
 * 	<li>Sich selbst in einem Document Object umzuwandeln, damit es in MongoDB gespeichert werden kann</li>
 * 	<li>Sich aus einem Document aus der Datenbank wieder in einem Java Object umzuwandeln</li>
 * </ul>
 * @author loicy
 *
 */
public interface Persistable {
	
	void initMongo();
	Document toDocument();
	void toObject(Document doc);
	

}
