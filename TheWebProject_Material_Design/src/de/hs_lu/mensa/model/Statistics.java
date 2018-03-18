package de.hs_lu.mensa.model;

import java.util.ArrayList;

import de.hs_lu_mensa_dataaccess.MongoConnection;

public class Statistics {
	
	private MongoConnection mongoConn;
	
	private ArrayList<RefectoryEvaluation> refectoryEvaluations;
	
	private int numberOfMeals;
	
	private int numberOfEvaluationOveral;
	private int numberOfEvaluationNormal;
	private int numberOfEvaluationQuick;
	private int numberOfRefectoryEvaluations;
	private int numberOfUsers;
	
	private int avg_quality, avg_diversity, avg_variety, avg_serving_size, avg;
	
	public Statistics() {
		super();
	}
	
	public void initCalculations(){
		
		int sum_quality = 0, sum_diversity = 0, sum_variety = 0, sum_serving_size = 0;
		RefectoryEvaluation refectoryEvaluationAnalysis = new RefectoryEvaluation();
		
		if(refectoryEvaluationAnalysis.mongoReadAll())
		refectoryEvaluations = refectoryEvaluationAnalysis.getRefectoryEvaluationsObjects();
		
		for (RefectoryEvaluation refectoryEvaluation : refectoryEvaluations) {
			sum_quality += refectoryEvaluation.getQuality();
			sum_diversity += refectoryEvaluation.getDiversity();
			sum_variety += refectoryEvaluation.getVariety();
			sum_serving_size += refectoryEvaluation.getServing_size();
		}
		
		int count = refectoryEvaluations.size();
		this.avg_quality = sum_quality / count;
		this.avg_diversity = sum_diversity / count;
		this.avg_variety = sum_variety / count;
		this.avg_serving_size = sum_serving_size / count;
		
		this.avg = (avg_diversity + avg_variety + avg_serving_size + avg_quality) / 4;
	}

	
	public void initMongo(){
		this.mongoConn = new MongoConnection();
	}
	
	
	public int getNumberOfMeals() {
		initMongo();
		
		this.numberOfMeals = (int)this.mongoConn.getMongoDataBase().getCollection("Meals").count();
		
		return numberOfMeals;
	}


	public int getNumberOfEvaluationOveral() {
		initMongo();
		this.numberOfEvaluationOveral = (int)this.mongoConn.getMongoDataBase().getCollection("MealEvaluations").count();
		this.numberOfEvaluationOveral += (int)this.mongoConn.getMongoDataBase().getCollection("QuickMealEvaluations").count();
		this.numberOfEvaluationOveral += (int)this.mongoConn.getMongoDataBase().getCollection("RefectoryEvaluations").count();
		
		return numberOfEvaluationOveral;
	}


	public int getNumberOfEvaluationNormal() {
		initMongo();
		
		this.numberOfEvaluationNormal = (int)this.mongoConn.getMongoDataBase().getCollection("MealEvaluations").count();
		
		return numberOfEvaluationNormal;
	}


	public int getNumberOfEvaluationQuick() {
		initMongo();
		
		this.numberOfEvaluationQuick = (int)this.mongoConn.getMongoDataBase().getCollection("QuickMealEvaluations").count();
		
		return numberOfEvaluationQuick;
	}


	public int getAvg_quality() {
		return avg_quality;
	}

	public int getAvg_diversity() {
		return avg_diversity;
	}

	public int getAvg_variety() {
		return avg_variety;
	}

	public int getAvg_serving_size() {
		return avg_serving_size;
	}

	public int getAvg() {
		return avg;
	}

	public int getNumberOfRefectoryEvaluations() {
		initMongo();
		
		this.numberOfRefectoryEvaluations = (int)this.mongoConn.getMongoDataBase().getCollection("RefectoryEvaluations").count();
		
		return numberOfRefectoryEvaluations;
	}


	public int getNumberOfUsers() {
		
		initMongo();
		
		this.numberOfUsers = (int)this.mongoConn.getMongoDataBase().getCollection("Users").count();
		
		return numberOfUsers;
	}

	public static void main(String[] args) {
		new Statistics().initCalculations();
	}

}
