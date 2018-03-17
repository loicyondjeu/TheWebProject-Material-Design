package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import de.hs_lu.mensa.helpers.Denullyfier;
import de.hs_lu.mensa.helpers.SessionManager;
import de.hs_lu.mensa.model.Meal;
import de.hs_lu.mensa.model.MealPlan;
import de.hs_lu.mensa.helpers.Messenger;


/**
 * Servlet implementation class findMealServlet
 */
@WebServlet("/findMeal")
public class FindMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		boolean planMeal = request.getParameter("choosedMeal") == null ? false:true;
		boolean search = Denullyfier.denullifyString(request.getParameter("search")).equals("suchen") ? true:false;
		
		if(search){
			boolean vegetarian = request.getParameter("vegetarian") == null ? false:true;
			boolean halal = request.getParameter("halal") == null ? false:true;
			
			Meal mealProfile = new Meal();
			mealProfile.setVegetarian(vegetarian);
			mealProfile.setHalal(halal);
			
			System.out.println(mealProfile.mongoRead());
			
			if(mealProfile.mongoRead()){
				ArrayList<Meal> meals = mealProfile.getMealList();
				System.out.println(meals.toString());
				request.getSession().setAttribute("mealList", meals);
				response.sendRedirect("jsp/planMeal.jsp");
			}else{
				Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
				messenger.setMessage(Messenger.SEARCH_FAILED);
				response.sendRedirect("jsp/messaging.jsp?direct=planMeal");
			}
		}else if(planMeal){
			ObjectId choosedMeal_id = new ObjectId(request.getParameter("choosedMeal"));
			
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
			try {
				date = formatter.parse(request.getParameter("date_submit"));
				System.out.println(date.toString());
			} catch (ParseException e) {
				System.out.println("Das Datum könnte nicht formatiert werden");
				e.printStackTrace();
			}
			
			
			MealPlan mealPlan = new MealPlan();
			mealPlan.setDate(date);
			
			if(mealPlan.mongoRead()){
				mealPlan.addMeal(choosedMeal_id);
				mealPlan.mongoUpdate();
			}else{
				mealPlan.mongoWrite();
			}
			
			Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
			messenger.setMessage(Messenger.SAVE_MEALPLAN_OK);
			response.sendRedirect("jsp/messaging.jsp?direct=planMeal");
		}
		


	}

}
