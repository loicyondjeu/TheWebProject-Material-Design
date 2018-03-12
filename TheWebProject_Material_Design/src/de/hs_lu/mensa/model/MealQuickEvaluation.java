package de.hs_lu.mensa.model;

import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;

import de.hs_lu_mensa_dataaccess.MongoConnection;

public class MealQuickEvaluation implements Persistable {
	private ObjectId meal_id;
	private String  soup, entree, complement, salad, dessert;
	private Date date;
	private MongoConnection mongoConn;
	private MongoCollection<Document> quickMealEvaluations;
	
	public MealQuickEvaluation() {
		super();
		this.date = new Date();
	}
	
	public void initMongo(){
		this.mongoConn = new MongoConnection();
		this.quickMealEvaluations = this.mongoConn.getMongoDataBase().getCollection("QuickMealEvaluations");
	}
	
	public void mongoWrite(){
		initMongo();
		quickMealEvaluations.insertOne(this.toDocument());
		mongoConn.close();
	}
	
	public void toObject(Document doc){
		this.setMeal_id(doc.getObjectId("meal"));
		this.setDate(doc.getDate("date"));
		this.setComplement(doc.getString("salad"));
		this.setEntree(doc.getString("entree"));
		this.setComplement(doc.getString("complement"));
		this.setDessert(doc.getString("dessert"));
		this.setSoup(doc.getString("soup"));
	}
	
	public Document toDocument() {
		Document quickMealEvalDoc = new Document();
		
		quickMealEvalDoc.append("meal", this.meal_id)
						.append("date", this.date)
						.append("salad", this.salad)
						.append("entree", this.entree)
						.append("complement", this.complement)
						.append("dessert", this.dessert)
						.append("soup", this.soup);
		
		return quickMealEvalDoc;
	}

	public ObjectId getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(ObjectId meal_id) {
		this.meal_id = meal_id;
	}

	public String getSoup() {
		return soup;
	}

	public void setSoup(String soup) {
		this.soup = soup;
	}

	public String getEntree() {
		return entree;
	}

	public void setEntree(String entree) {
		this.entree = entree;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getSalad() {
		return salad;
	}

	public void setSalad(String salad) {
		this.salad = salad;
	}

	public String getDessert() {
		return dessert;
	}

	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
