package de.hs_lu.mensa.model;

import java.util.Date;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import de.hs_lu_mensa_dataaccess.MongoConnection;

public class MealEvaluation {
	
	Long meal_id;
	Integer stars;
	String emoticon, comment;
	private Date day;
	private MongoCollection<Document> mealEvaluations; 
	
	public MealEvaluation(){
		
	}
	
	public void persist(){
		MongoConnection mongoConn = new MongoConnection();
		this.mealEvaluations = mongoConn.getMongoDataBase().getCollection("MealEvaluations");
		mealEvaluations.insertOne(this.toDocument());
		mongoConn.close();
	}

	private Document toDocument() {
		Document mealEvaluationDoc = new Document();
		
		mealEvaluationDoc.append("meal_id", this.meal_id)
		   				 .append("stars", this.stars )
		   					  .append("emoticon", this.emoticon)
		   					  .append("comment",this.comment)
		   					  .append("date", this.day);
	
		return mealEvaluationDoc;
	}
	
	public Long getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(Long meal_id) {
		this.meal_id = meal_id;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public String getEmoticon() {
		return emoticon;
	}

	public void setEmoticon(String emoticon) {
		this.emoticon = emoticon;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}
	
	
	

}
