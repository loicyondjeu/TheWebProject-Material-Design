package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String name = request.getParameter("name");
		String entree = request.getParameter("entree");
		Boolean vegetarian = request.getParameter("vegetarian") == null ? false : true;
		Boolean halal = request.getParameter("halal") == null ? false : true;
		String description = request.getParameter("description");
		Double energy = Double.valueOf(request.getParameter("energy"));
		
		ArrayList<String> vitamins =  new ArrayList<String>();
		for (int i = 1; i < 6; i++)
			vitamins.add(request.getParameter("v"+i));
		String allergies = request.getParameter("allergies");
		
		/*HANDLE BEAN*/
		//Anlegen einer Bean für die Speise
		Meal meal = new Meal();
		meal.setName(name);
		meal.setEntree(entree);
		meal.setVegetarian(vegetarian);
		meal.setHalal(halal);
		meal.setDescription(description);
		meal.setEnergy(energy);
		meal.setVitamins(vitamins);
		meal.setAllergies(allergies);
		
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
