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
import de.hs_lu_mensa_dataaccess.MongoTester;

/**
 * Die Klasse CreateMealServlet ist für alle Anfragen zum Anlegen einer Speise verantwortlich.
 * Dafür liest sie die Daten aus dem Request, erstellt eine Speise als Java Objekt und ruft die Methode des Java Objekt, damit
 * Es sich seblst in der Datenbank speichert.
 * <p><strong>Note</strong>: Nicht alle Daten der Speise müssen ausgefüllt sein.</p>
 */
@WebServlet("/createMeal")
public class CreateMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		
		/*REQUEST HANDLING*/
		
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
		
		Double energy = Double.valueOf(Denullyfier.denullifyDouble(request.getParameter("energy")));
		Double protein = Double.valueOf(Denullyfier.denullifyDouble(request.getParameter("protein")));
		Double fat = Double.valueOf(Denullyfier.denullifyDouble(request.getParameter("fat")));
		Double carbs= Double.valueOf(Denullyfier.denullifyDouble(request.getParameter("carbs")));
		
		/*Vitamins mit Hilfe ihrer Name Attribute in ArrayList speichern*/
		ArrayList<String> vitamins =  new ArrayList<String>();
		for (int i = 1; i < 6; i++){
			String vitamin = request.getParameter("v"+i);
			if(vitamin != null)
				vitamins.add(vitamin);
		}
		
		/*Vitamins mit Hilfe ihrer Name Attribute in ArrayList speichern*/
		ArrayList<String> allergies =  new ArrayList<String>();
		for (int i = 1; i < 6; i++){
			String allergie = request.getParameter("allergie"+i);
			if(allergie != null)
				allergies.add(allergie);
		}
		
		String image = Denullyfier.denullifyString(request.getParameter("image"));
		
		
		/* BEAN HANDLING */
		//Da Alle Daten aus dem Resquest sauber gelesen worden sind, erzeugt der Controller ein Objekt Speise

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
		
		
		/* DATENBANK HANDLING */
		
		//Der Controller testet ob eine Datenbank verbindung liegt
		if(MongoTester.testMongo()){	
			
			meal.mongoWrite();
			
			/* RESPONSE HANDLING */
			
			//Der Controller benachrichtigt den User für den Erfolg und führt zurück der Ansicht.
			Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
			messenger.setMessage(Messenger.CREATE_MEAL_OK);
			response.sendRedirect("jsp/messaging.jsp?direct=createMeal");
			
		}else{
			
			/* RESPONSE HANDLING */
			
			//Der Controller benachrichtigt den User für den Ausfall der Datenbank und führt zur der Anmelde Seite.
			Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
			messenger.setMessage(Messenger.MONGO_ERROR);
			response.sendRedirect("jsp/messaging.jsp?direct=signin");
			
		}
		
	}

}
