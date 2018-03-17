package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hs_lu.mensa.helpers.Denullyfier;
import de.hs_lu.mensa.helpers.Messenger;
import de.hs_lu.mensa.helpers.SessionManager;
import de.hs_lu.mensa.model.Meal;

/**
 * Die Klasse CreateMealServlet ist für alle Anfragen zum Anlegen eines Speise verantwortlich.
 * Dafür liest sie die Daten aus dem Request, erste llt eine Speise als Java Objekt und ruft die Methode des Java Objekt, damit
 * Es sich seblst in der Datenbank speichert.
 * <p><strong>Note</strong>: Nicht alle Daten der Speise müssen ausgefüllt sein.</p>
 */
@WebServlet("/createMeal")
public class CreateMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		
		/*HANDLE REQUEST*/
		
		//Request Verarbeitung
		request.setCharacterEncoding("UTF-8");
	    
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		String soup = request.getParameter("soup");
		String salad = request.getParameter("salad");
		String entree = request.getParameter("entree");
		String complement = request.getParameter("complement");
		String dessert = request.getParameter("dessert");
		
		
		
		Boolean vegetarian = request.getParameter("vegetarian") == null ? false : true;
		Boolean halal = request.getParameter("halal") == null ? false : true;
		Boolean pescetarian = request.getParameter("pescetarian") == null ? false : true;
		
		Double energy = Double.valueOf(request.getParameter("energy"));
		Double protein = Double.valueOf(request.getParameter("protein"));
		Double fat = Double.valueOf(request.getParameter("fat"));
		Double carbs= Double.valueOf(request.getParameter("carbs"));
		
		ArrayList<String> vitamins =  new ArrayList<String>();
		for (int i = 1; i < 6; i++){
			String vitamin = request.getParameter("v"+i);
			if(vitamin != null)
				vitamins.add(vitamin);
		}
		
		ArrayList<String> allergies =  new ArrayList<String>();
		for (int i = 1; i < 6; i++){
			String allergie = request.getParameter("allergie"+i);
			if(allergie != null)
				allergies.add(allergie);
		}
		
		String image = Denullyfier.denullifyString(request.getParameter("image"));
		
		
		/*HANDLE BEAN*/
		
		//Anlegen der Bean für die Speise
		Meal meal = new Meal();
		
		meal.setName(name);
		meal.setDescription(description);
		
		meal.setSoup(soup);
		meal.setSalad(salad);
		meal.setEntree(entree);
		meal.setDessert(dessert);
		meal.setComplement(complement);
		
		meal.setVegetarian(vegetarian);
		meal.setHalal(halal);
		meal.setPescetarian(pescetarian);
		
		meal.setEnergy(energy);
		meal.setProtein(protein);
		meal.setFat(fat);
		meal.setCarbs(carbs);
		
		meal.setVitamins(vitamins);
		
		meal.setAllergies(allergies);
		
		meal.setImage(image);
		
		
		/*HANDLE DB*/
		
		//Speise schreibt sich selbst in DB
		meal.mongoWrite();
		
		/*HANDLE RESPONSE*/
		
		//Handle Response
		Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
		messenger.setMessage(Messenger.CREATE_MEAL_OK);
		response.sendRedirect("jsp/messaging.jsp?direct=createMeal");

		
		
	}

}
