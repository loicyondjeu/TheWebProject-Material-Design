package de.hs_lu.mensa.helpers;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletContext;

import de.hs_lu.mensa.model.Meal;
import de.hs_lu.mensa.model.MealPlan;
import de.hs_lu.mensa.model.Statistics;

public abstract class ApplicationManager {
	
	 public static void setUpTodayMeals(ServletContext application) throws ParseException{
		  try {
			Date today = DateHelper.getDateTimeRemoved(new Date());
			  
			  MealPlan todayMealPlan = new MealPlan();
			  todayMealPlan.setDate(today);
			  
			  todayMealPlan.mongoRead();
			  
			  //Für den Debug
			  System.out.println("Die IDs der Speise für heute sind:" + todayMealPlan.getRelatedMeals_ids().toString());
			  
			  if(todayMealPlan.getRelatedMeals_ids().size() >= 2){
				  Meal todayMealVegetarian = new Meal();
				  todayMealVegetarian.setMeal_id(todayMealPlan.getRelatedMeals_ids().get(0));
				  
				  todayMealVegetarian.mongoReadById();
				  
				  Meal todayMealVegetarianTemp = (Meal)application.getAttribute("todayMealVegetarian");
				  if(todayMealVegetarianTemp == null){
					  application.setAttribute("todayMealVegetarian", todayMealVegetarian);
				  }
				  
				  
				  Meal todayMealVollkost = new Meal();
				  todayMealVollkost.setMeal_id(todayMealPlan.getRelatedMeals_ids().get(1));
				  
				  todayMealVollkost.mongoReadById();
				  
				  Meal todayMealVollkostTemp = (Meal)application.getAttribute("todayMealVollkost");
				  if(todayMealVollkostTemp == null){
					  application.setAttribute("todayMealVollkost", todayMealVollkost);
				  }
			  }
		} catch (Exception e) {
			//Das Laden der heutigen Speisen ist fehlgeschlagen
			e.printStackTrace();
		}
		  
	 }
	 
	 
	 public static void setUpTomorrowMeals(ServletContext application) throws ParseException{
		  try {
				Date tomorrow = DateHelper.getTomorrowTimeRemoved(new Date());
				  
				  MealPlan tomorrowMealPlan = new MealPlan();
				  tomorrowMealPlan.setDate(tomorrow);
				  
				  tomorrowMealPlan.mongoRead();
				  
				  //Für den Debug
				  System.out.println("Die IDs der Speise für morgen sind:" + tomorrowMealPlan.getRelatedMeals_ids().toString());
				  
				  if(tomorrowMealPlan.getRelatedMeals_ids().size() >= 2){
					  Meal tomorrowMealVegetarian = new Meal();
					  tomorrowMealVegetarian.setMeal_id(tomorrowMealPlan.getRelatedMeals_ids().get(0));
					  
					  tomorrowMealVegetarian.mongoReadById();
					  
					  Meal tomorrowMealVegetarianTemp = (Meal)application.getAttribute("tomorrowMealVegetarian");
					  if(tomorrowMealVegetarianTemp == null){
						  application.setAttribute("tomorrowMealVegetarian", tomorrowMealVegetarian);
					  }
					  
					  
					  Meal tomorrowMealVollkost = new Meal();
					  tomorrowMealVollkost.setMeal_id(tomorrowMealPlan.getRelatedMeals_ids().get(1));
					  
					  tomorrowMealVollkost.mongoReadById();
					  
					  Meal tomorrowMealVollkostTemp = (Meal)application.getAttribute("tomorrowMealVollkost");
					  if(tomorrowMealVollkostTemp == null){
						  application.setAttribute("tomorrowMealVollkost", tomorrowMealVollkost);
					  }
				  }
				  
				  
			} catch (Exception e) {
				//Das Laden der morgigen Speisen ist fehlgeschlagen
				e.printStackTrace();
			}
		  
	 }
	 
	 public static void setUpStatistics(ServletContext application){	 
		 try {
			Statistics statistics = new Statistics();
			 statistics.initCalculations();
			 
			 Statistics statisticsTemp = (Statistics)application.getAttribute("statistics");
			  if(statisticsTemp == null){
				  application.setAttribute("statistics", statistics);
			  }
		} catch (Exception e) {
			//Das Laden der Statistiken ist fehlgeschlagen
			e.printStackTrace();
		}
	 }

}
