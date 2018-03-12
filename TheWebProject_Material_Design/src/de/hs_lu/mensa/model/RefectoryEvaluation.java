package de.hs_lu.mensa.model;


import java.util.Date;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import de.hs_lu_mensa_dataaccess.MongoConnection;

public class RefectoryEvaluation implements Persistable {
	private Integer quality, diversity, variety, serving_size;
	private Date date;
	
	private MongoConnection mongoConn;
	private MongoCollection<Document> refectoryEvaluations;
	
	public RefectoryEvaluation(){
		super();
	}
	
	public void initMongo(){
		this.mongoConn = new MongoConnection();
		this.refectoryEvaluations = this.mongoConn.getMongoDataBase().getCollection("RefectoryEvaluations");
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

	@Override
	public String toString() {
		return String.format(
				"RefectoryEvaluation [quality=%s, diversity=%s, variety=%s, serving_size=%s, date=%s, refectoryEvaluations=%s]",
				quality, diversity, variety, serving_size, date, refectoryEvaluations);
	}


}
