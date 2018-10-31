package de.hs_lu.mensa.model;

import java.util.ArrayList;
import java.util.Date;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import de.hs_lu_mensa_dataaccess.MongoConnection;

public class MealPlan implements Persistable {
	Date date;
	ArrayList<ObjectId> relatedMeals_ids;
	
	private MongoConnection mongoConn;
	private MongoCollection<Document> mealPlans;
	
	public MealPlan(){
	 super();	
	 relatedMeals_ids = new ArrayList<ObjectId>();
	}

	public void initMongo(){
		this.mongoConn = new MongoConnection();
		this.mealPlans = this.mongoConn.getMongoDataBase().getCollection("MealPlans");
	}
	
	public boolean mongoRead(){
		initMongo();
		
		Bson dateCondition = Filters.eq("date", this.getDate());
		
		Document mealPlanDoc = this.mealPlans.find(dateCondition).first();
		
		this.mongoConn.close();
		
		if(mealPlanDoc != null){
			this.toObject(mealPlanDoc);
			return true;
		}
		
		return false;
	}
	
	public void mongoUpdate(){
		initMongo();
		
		Bson dateCondition = Filters.eq("date", this.getDate());
		
	    mealPlans.updateOne(dateCondition, Updates.set("meals", this.getRelatedMeals_ids()));
	    
		this.mongoConn.close();
	}
	
	public void mongoWrite(){
		initMongo();
		mealPlans.insertOne(this.toDocument());
		mongoConn.close();
	}
	
	public void toObject(Document doc){
		this.setDate(doc.getDate("date"));
		ArrayList<ObjectId> relatedMeals_ids = (ArrayList<ObjectId>) doc.get("meals");
		this.setRelatedMeals_ids(relatedMeals_ids);
	}
	
	public Document toDocument() {
		Document mealPlanDoc = new Document();
		
		mealPlanDoc.append("date", this.date)
			       .append("meals", this.getRelatedMeals_ids());
		
		return mealPlanDoc;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void addMeal(ObjectId meal_id){
	  relatedMeals_ids.add(meal_id);
	}

	public ArrayList<ObjectId> getRelatedMeals_ids() {
		return relatedMeals_ids;
	}

	public void setRelatedMeals_ids(ArrayList<ObjectId> relatedMeals_ids) {
		this.relatedMeals_ids = relatedMeals_ids;
	}

}
