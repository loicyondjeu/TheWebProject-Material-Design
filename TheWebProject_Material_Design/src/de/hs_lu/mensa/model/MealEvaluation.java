package de.hs_lu.mensa.model;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;

import de.hs_lu_mensa_dataaccess.MongoConnection;

public class MealEvaluation implements Persistable {
	private ObjectId meal_id;
	private Integer freshness, serving_size, taste;
	private String comment;
	
	private MongoConnection mongoConn;
	private MongoCollection<Document> mealEvaluations;
	
	public MealEvaluation(){
		super();
	}
	
	public void initMongo(){
		this.mongoConn = new MongoConnection();
		this.mealEvaluations = this.mongoConn.getMongoDataBase().getCollection("MealEvaluations");
	}
	
	
	public void mongoWrite(){
		initMongo();
		mealEvaluations.insertOne(this.toDocument());
		mongoConn.close();
	}
	
	
	public void toObject(Document doc){
		this.setMeal_id(doc.getObjectId("meal"));
		this.setTaste(doc.getInteger("taste"));
		this.setFreshness(doc.getInteger("freshness"));
		this.setServing_size(doc.getInteger("serving_size"));
		this.setComment(doc.getString("comment"));
	}
	
	public Document toDocument() {
		Document mealEvalDoc = new Document();
		
		mealEvalDoc.append("meal", this.meal_id)
				.append("freshness", this.freshness)
				.append("serving_size", this.serving_size)
				.append("taste", this.taste)
				.append("comment", this.comment);
		
		return mealEvalDoc;
	}

	public ObjectId getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(ObjectId meal_id) {
		this.meal_id = meal_id;
	}

	public Integer getFreshness() {
		return freshness;
	}

	public void setFreshness(Integer freshness) {
		this.freshness = freshness;
	}

	public Integer getServing_size() {
		return serving_size;
	}

	public void setServing_size(Integer serving_size) {
		this.serving_size = serving_size;
	}

	public Integer getTaste() {
		return taste;
	}

	public void setTaste(Integer taste) {
		this.taste = taste;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
