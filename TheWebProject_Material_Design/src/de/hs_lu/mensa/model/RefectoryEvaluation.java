package de.hs_lu.mensa.model;

import java.util.Date;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import de.hs_lu_mensa_dataaccess.MongoConnection;

public class RefectoryEvaluation {
	
	private Integer quality, diversity, variety, serving_size;
	private Date day;
	private MongoCollection<Document> refectoryEvaluations;
	
	public RefectoryEvaluation(){
		
	}
	
	public void persist(){
		MongoConnection mongoConn = new MongoConnection();
		this.refectoryEvaluations = mongoConn.getMongoDataBase().getCollection("RefectoryEvaluations");
		refectoryEvaluations.insertOne(this.toDocument());
		mongoConn.close();
	}

	private Document toDocument() {
		Document refectoryEvaluationDoc = new Document();
		
		refectoryEvaluationDoc.append("quality", this.quality)
		   					  .append("variety", this.variety)
		   					  .append("serving_size", this.serving_size)
		   					  .append("diversity",this.diversity)
		   					  .append("date", this.day);
	
		return refectoryEvaluationDoc;
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

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}
	

}
