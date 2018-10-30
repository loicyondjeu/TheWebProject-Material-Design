package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import de.hs_lu.mensa.helpers.DateHelper;
import de.hs_lu.mensa.helpers.Denullyfier;
import de.hs_lu.mensa.helpers.SessionManager;
import de.hs_lu.mensa.model.Meal;
import de.hs_lu.mensa.model.MealPlan;
import de.hs_lu_mensa_dataaccess.MongoTester;
import de.hs_lu.mensa.helpers.Messenger;


/**
 * Dieser Controller übernimmt mehrere Aufgaben, die nicht unbedingt mit findMeal zu tun haben.
 * Der Name sollte während der Wartbarkeit von uns geändert werden. Er wird jedoch auf Grund der Dringlichkeit gelassen. !
 * Der Controller kann eine Speise an einem bestimmten Tag planen.
 * Er kann auch nach Speise in der DB suchen.
 * Außerdem kann er auch Speise löschen.
 */
@WebServlet("/findMeal")
public class FindMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* SESSION HANDLING */
		Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
		
		/* REQUEST HANDLING */
		request.setCharacterEncoding("UTF-8");
		
		 //AKTION PRÜFUNG
		
		  /*Prüft ob eine Speise gelöscht oder geplant werden muss*/
		boolean deleteMeal = request.getParameter("deleteMeal") == null ? false:true;
		boolean planMeal = request.getParameter("choosedMeal") == null ? false:true;
		  /*Prüft ob eher die Suche erledigt werden soll*/		
		boolean search = Denullyfier.denullifyString(request.getParameter("search")).equals("suchen") ? true:false;
		
		if(search){
			
			/* REQUEST HANDLING */
			
			boolean vegetarian = request.getParameter("vegetarian") == null ? false:true;
			boolean halal = request.getParameter("halal") == null ? false:true;
			
			
			/* BEAN HANDLING */
			//Controller erzeugt ein Objekt Speise als Suchprofil für die zu suchenden Speisen			
			Meal mealProfile = new Meal();
			
			mealProfile.setVegetarian(vegetarian);
			mealProfile.setHalal(halal);
			
			/* DATENBANK HANDLING */
			
			//Der Controller testet ob eine Datenbank Verbindung vorliegt

			if(MongoTester.testMongo()){
				
				if(mealProfile.mongoRead()){
					
					/* RESPONSE HANDLING */						
					ArrayList<Meal> meals = mealProfile.getMealList();
					
					request.getSession().setAttribute("mealList", meals);
					request.getSession().setAttribute("mealListSize", meals.size());
					response.sendRedirect("jsp/planMeal.jsp");
					
				}else{
					
					/* RESPONSE HANDLING */	
					messenger.setMessage(Messenger.SEARCH_FAILED);
					response.sendRedirect("jsp/messaging.jsp?direct=planMeal");
				}
				
			}else{
				
				/* RESPONSE HANDLING */
				
				//Der Controller benachrichtigt den User für den Ausfall der Datenbank und führt zur der Anmelde Seite.
				messenger.setMessage(Messenger.MONGO_ERROR);
				response.sendRedirect("jsp/messaging.jsp?direct=signin");				
			}	
			
		}else if(planMeal){
			
			ObjectId choosedMeal_id;
			try {
				choosedMeal_id = new ObjectId(Denullyfier.denullifyString(request.getParameter("choosedMeal")));
				
				Date date = DateHelper.getDateFormatted(request.getParameter("date_submit"));
				
				MealPlan mealPlan = new MealPlan();
				mealPlan.setDate(date);
				
				if(mealPlan.mongoRead()){
					mealPlan.addMeal(choosedMeal_id);
					mealPlan.mongoUpdate();
				}else{
					mealPlan.mongoWrite();
				}
				
				messenger.setMessage(Messenger.SAVE_MEALPLAN_OK);
				response.sendRedirect("jsp/messaging.jsp?direct=planMeal");
				
			} catch (IllegalArgumentException iae) {
				messenger.setMessage(Messenger.EVAL_ERROR);
				response.sendRedirect("jsp/messaging.jsp?direct=index");
				
				iae.printStackTrace();
				
			} catch (ParseException e) {
				messenger.setMessage(Messenger.DATE_ERROR);
				response.sendRedirect("jsp/messaging.jsp?direct=index");
				
				e.printStackTrace();
			}
			
		}else if(deleteMeal){
			
			ObjectId deleteMeal_id;
			try {
				deleteMeal_id = new ObjectId(Denullyfier.denullifyString(request.getParameter("deleteMeal")));
				
				Meal meal = new Meal();
				meal.setMeal_id(deleteMeal_id);
				
				meal.mongoDelete();
				
				messenger.setMessage(Messenger.DELETE_MEAL_OK);
				response.sendRedirect("jsp/messaging.jsp?direct=planMeal");
				
				
			} catch (IllegalArgumentException iae) {
				messenger.setMessage(Messenger.EVAL_ERROR);
				response.sendRedirect("jsp/messaging.jsp?direct=index");
				
				iae.printStackTrace();
				
			}

		}
		


	}

}
