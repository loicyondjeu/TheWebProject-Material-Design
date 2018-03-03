package de.hs_lu.mensa.model;

import java.util.Date;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import de.hs_lu_mensa_dataaccess.MongoConnection;

public class QuickMealEvaluation {

	Long meal_id;
	String soup, entree, dessert, complement, salad;
	Date day;
	private  MongoCollection<Document> quickMealEvaluations; 
	
	public QuickMealEvaluation(){
		
	}
	
	public void persist(){
		MongoConnection mongoConn = new MongoConnection();
		this.quickMealEvaluations = mongoConn.getMongoDataBase().getCollection("quickMealEvaluations");
		quickMealEvaluations.insertOne(this.toDocument());
		mongoConn.close();
	}
	
	private Document toDocument() {
		Document quickMealEvaluationDoc = new Document();
		
		quickMealEvaluationDoc.append("meal_id", this.meal_id)
		   				 	  .append("soup", this.soup)
		   					  .append("complement", this.complement)
		   					  .append("dessert",this.dessert)
		   					  .append("entree", this.entree)
		   					  .append("salad", this.salad)
		   					  .append("date", this.day);
	
		return quickMealEvaluationDoc;
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
	public String getDessert() {
		return dessert;
	}
	public void setDessert(String dessert) {
		this.dessert = dessert;
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
	public void setSalad(String salat) {
		this.salad = salat;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	
	
	
	
}
