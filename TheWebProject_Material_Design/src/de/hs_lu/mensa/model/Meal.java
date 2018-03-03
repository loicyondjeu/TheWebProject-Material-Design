package de.hs_lu.mensa.model;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import de.hs_lu_mensa_dataaccess.MongoConnection;

public class Meal {
	String name, description, soup, entree, complement, salad, dessert, allergies;
	Boolean vegetarian, thumsup;
	int stars; 
	String image;
	double energy, protein, fat, carbs, avg_evaluation;
	ArrayList<String> vitamins, comments;
	
	private MongoCollection<Document> meals;
	
	public Meal(){
		super();
	}
	
	public void persist(){
		MongoConnection mongoConn = new MongoConnection();
		this.meals = mongoConn.getMongoDataBase().getCollection("Meals");
		meals.insertOne(this.getDocument());
		mongoConn.close();
	}

	public Document getDocument() {
		Document mealDoc = new Document();
		
		mealDoc.append("name", this.name)
				.append("entree", this.entree)
				.append("vegetarian", this.vegetarian)
				.append("description", this.description)
				.append("energy", this.energy)
				.append("vitamins", this.vitamins)
				.append("allergies", this.allergies);
		
		return mealDoc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public boolean isThumsup() {
		return thumsup;
	}

	public void setThumsup(boolean thumsup) {
		this.thumsup = thumsup;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getCarbs() {
		return carbs;
	}

	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

	public double getAvg_evaluation() {
		return avg_evaluation;
	}

	public void setAvg_evaluation(double avg_evaluation) {
		this.avg_evaluation = avg_evaluation;
	}

	public ArrayList<String> getVitamins() {
		return vitamins;
	}

	public void setVitamins(ArrayList<String> vitamins) {
		this.vitamins = vitamins;
	}

	public ArrayList<String> getComments() {
		return comments;
	}

	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Meal [name=").append(name).append(", type=").append(", description=")
				.append(description).append(", soup=").append(soup).append(", entree=").append(entree)
				.append(", complement=").append(complement).append(", salad=").append(salad).append(", dessert=")
				.append(dessert).append(", allergies=").append(allergies).append(", vegetarian=").append(vegetarian)
				.append(", thumsup=").append(thumsup).append(", stars=").append(stars).append(", energy=")
				.append(energy).append(", protein=").append(protein).append(", fat=").append(fat).append(", carbs=")
				.append(carbs).append(", avg_evaluation=").append(avg_evaluation).append(", vitamins=").append(vitamins)
				.append(", comments=").append(comments).append("]");
		return builder.toString();
	}
	
	
}
