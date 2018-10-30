package de.hs_lu.mensa.model;


import java.util.ArrayList;
import java.util.Date;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import de.hs_lu_mensa_dataaccess.MongoConnection;

/**
 * Die Klasse modelliert die Bewertung eines Mensa Gast für die Mensa.
 * Die Mensa wird vom Gast auf 4 Charakteristiken gemessen.
 * Die Diversität der Speise, die Abwechslung, die Qualität und die Portionsgröße.
 * Es können weitere Charakteristiken hinzugefügt werden.
 * Außerdem wird das Datum der Bewertung hinterlegt.
 * 
 *  Die Werte werden auf einem Skala von 1 bis 10 gemessen.
 * @author loicy
 *
 */
public class RefectoryEvaluation implements Persistable {
	private Integer quality, diversity, variety, serving_size;
	private Date date;
	
	private MongoConnection mongoConn;
	private MongoCollection<Document> refectoryEvaluations;
	private ArrayList<RefectoryEvaluation> refectoryEvaluationsObjects;
	
	public RefectoryEvaluation(){
		super();
	}
	
	public void initMongo(){
		this.mongoConn = new MongoConnection();
		this.refectoryEvaluations = this.mongoConn.getMongoDataBase().getCollection("RefectoryEvaluations");
	}
	
	public boolean mongoReadAll(){
		initMongo();
		
		refectoryEvaluationsObjects = new ArrayList<RefectoryEvaluation>();
		MongoCursor<Document> cursor = this.refectoryEvaluations.find().iterator();
		
		try{
			while(cursor.hasNext()){
				toObject(cursor.next());
				refectoryEvaluationsObjects.add((RefectoryEvaluation)this.clone());
			}
		}finally{
			cursor.close();
			this.mongoConn.close();
		}
		
		if(refectoryEvaluationsObjects.isEmpty())	return false;
		
		return true;
	}
	
	public void toObject(Document doc){
		this.setQuality(doc.getInteger("quality"));
		this.setDiversity(doc.getInteger("diversity"));
		this.setVariety(doc.getInteger("serving_size"));
		this.setServing_size(doc.getInteger("serving_size"));
		this.setDate(doc.getDate("date"));
	}
	
	public Document toDocument() {
		Document doc = new Document();
		
		doc.append("quality", this.quality)
		   .append("diversity", this.diversity)
		   .append("variety", this.variety)
		   .append("serving_size", this.serving_size)
		   .append("date", this.date);
		
		return doc;
	}
	
	public void mongoWrite(){
		initMongo();
		refectoryEvaluations.insertOne(this.toDocument());
		mongoConn.close();
	}

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public Integer getDiversity() {
		return diversity;
	}

	public void setDiversity(Integer diversity) {
		this.diversity = diversity;
	}

	public Integer getVariety() {
		return variety;
	}

	public void setVariety(Integer variety) {
		this.variety = variety;
	}

	public Integer getServing_size() {
		return serving_size;
	}

	public void setServing_size(Integer serving_size) {
		this.serving_size = serving_size;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<RefectoryEvaluation> getRefectoryEvaluationsObjects() {
		return refectoryEvaluationsObjects;
	}

	@Override
	public String toString() {
		return String.format(
				"RefectoryEvaluation [quality=%s, diversity=%s, variety=%s, serving_size=%s, date=%s, refectoryEvaluations=%s]",
				quality, diversity, variety, serving_size, date, refectoryEvaluations);
	}
	
	@Override
	public RefectoryEvaluation clone(){
		RefectoryEvaluation refectoryEvalClone = new RefectoryEvaluation();
		
		refectoryEvalClone.setVariety(this.variety);
		refectoryEvalClone.setDiversity(this.diversity);
		refectoryEvalClone.setServing_size(this.serving_size);
		refectoryEvalClone.setQuality(this.quality);
		
		return refectoryEvalClone;
	}


}
