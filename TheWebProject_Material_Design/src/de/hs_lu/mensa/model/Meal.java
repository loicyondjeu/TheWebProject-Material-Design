package de.hs_lu.mensa.model;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import de.hs_lu_mensa_dataaccess.MongoConnection;

public class Meal implements Persistable {
	private ObjectId meal_id;
	private String name, description, soup, entree, complement, salad, dessert, allergies;
	private Boolean vegetarian, halal, thumsup;
	private int stars; 
	private String image;
	private double energy, protein, fat, carbs, avg_evaluation;
	private ArrayList<String> vitamins, comments;
	
	private MongoConnection mongoConn;
	private MongoCollection<Document> meals;
	private MealList mealList;
	
	public Meal(){
		super();
	}
	
	public void initMongo(){
		this.mongoConn = new MongoConnection();
		this.meals = this.mongoConn.getMongoDataBase().getCollection("Meals");
	}
	
	
	public boolean mongoRead(){
		initMongo();
		
		Bson vegetarian = Filters.eq("vegetarian", this.vegetarian);
		Bson halal = Filters.eq("halal", this.halal);
		
		mealList = new MealList();
		MongoCursor<Document> cursor = this.meals.find(Filters.and(vegetarian, halal)).iterator();
		
		try{
			while(cursor.hasNext()){
				toObject(cursor.next());
				mealList.add(this.clone());
			}
		}finally{
			cursor.close();
		}
		
		if(mealList.isEmpty())	return false;
		
		return true;
	}
	
	public boolean mongoReadById(){
		initMongo();
		
		Bson meal_idCondition = Filters.eq("_id", this.meal_id);
		
		Document mealDoc = this.meals.find(meal_idCondition).first();
		
		if(mealDoc != null){
			this.toObject(mealDoc);
			return true;
		}

		
		return false;
	}
	
	public void mongoWrite(){
		initMongo();
		meals.insertOne(this.toDocument());
		mongoConn.close();
	}

	public void toObject(Document doc){
		this.setMeal_id(doc.getObjectId("_id"));
		this.setName(doc.getString("name"));
	}
	
	public Document toDocument() {
		Document mealDoc = new Document();
		
		mealDoc.append("name", this.name)
				.append("entree", this.entree)
				.append("vegetarian", this.vegetarian)
				.append("halal", this.halal)
				.append("description", this.description)
				.append("energy", this.energy)
				.append("vitamins", this.vitamins)
				.append("allergies", this.allergies);
		
		return mealDoc;
	}

	public ObjectId getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(ObjectId meal_id) {
		this.meal_id = meal_id;
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

	
	public Boolean getHalal() {
		return halal;
	}

	public void setHalal(Boolean halal) {
		this.halal = halal;
	}

	public MealList getMealList() {
		return mealList;
	}

	public void setMealList(MealList mealList) {
		this.mealList = mealList;
	}
	
	@Override
	public Meal clone(){
		Meal mealClone = new Meal();
		mealClone.setMeal_id(meal_id);
		mealClone.setName(this.name);
		mealClone.setDescription(this.description);
		return mealClone;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Meal [name=%s, description=%s, soup=%s, entree=%s, complement=%s, salad=%s, dessert=%s, allergies=%s, vegetarian=%s, halal=%s, thumsup=%s, stars=%s, image=%s, energy=%s, protein=%s, fat=%s, carbs=%s, avg_evaluation=%s, vitamins=%s, comments=%s, meals=%s, mealList=%s]",
				name, description, soup, entree, complement, salad, dessert, allergies, vegetarian, halal, thumsup,
				stars, image, energy, protein, fat, carbs, avg_evaluation, vitamins, comments, meals, mealList);
	}


	
	
}
