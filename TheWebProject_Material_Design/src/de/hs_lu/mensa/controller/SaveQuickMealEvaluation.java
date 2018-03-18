package de.hs_lu.mensa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import de.hs_lu.mensa.helpers.Denullyfier;
import de.hs_lu.mensa.helpers.Messenger;
import de.hs_lu.mensa.helpers.SessionManager;
import de.hs_lu.mensa.model.MealQuickEvaluation;
import de.hs_lu_mensa_dataaccess.MongoTester;

/**
 * Dieser Controller speichert eine schnelle Bewertung für eine Speise.
 */
@WebServlet("/saveQuickMealEvaluation")
public class SaveQuickMealEvaluation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* SESSION HANDLING */
		Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
		
		/*REQUEST HANDLING*/
		request.setCharacterEncoding("UTF-8");
		
		String salad = Denullyfier.denullifyString(request.getParameter("salad")); 
		String soup = Denullyfier.denullifyString(request.getParameter("soup"));
		String dessert = Denullyfier.denullifyString(request.getParameter("dessert")); 
		String entree = Denullyfier.denullifyString(request.getParameter("entree")); 
		String complement = Denullyfier.denullifyString(request.getParameter("complement"));
		
		boolean bewerten = Denullyfier.denullifyString(request.getParameter("bewerten")).equals("bewerten") ? true:false;
		
		
		if(bewerten){
			
			ObjectId meal_id;
			try {
				meal_id = new ObjectId(Denullyfier.denullifyString(request.getParameter("meal")));
				
				/* BEAN HANDLING */
				//Da Alle Daten aus dem Resquest sauber gelesen worden sind, erzeugt der Controller ein Objekt Speise
				MealQuickEvaluation eval = new MealQuickEvaluation();
				eval.setMeal_id(meal_id);
				eval.setComplement(complement);
				eval.setDessert(dessert);
				eval.setEntree(entree);
				eval.setSalad(salad);
				eval.setSoup(soup);
				
				
				/* DATENBANK HANDLING */
				
				//Der Controller testet ob eine Datenbank verbindung liegt
				if(MongoTester.testMongo()){	
					
					eval.mongoWrite();
					
					/* RESPONSE HANDLING */
					
					//Der Controller benachrichtigt den User für den Erfolg und führt zurück der Ansicht.
					messenger.setMessage(Messenger.THANKS_FOR_EVAL);
					response.sendRedirect("jsp/messaging.jsp?direct=index");
					
				}else{
					
					/* RESPONSE HANDLING */
					
					//Der Controller benachrichtigt den User für den Ausfall der Datenbank und führt zur der Anmelde Seite.
					messenger.setMessage(Messenger.MONGO_ERROR);
					response.sendRedirect("jsp/messaging.jsp?direct=signin");
					
				}
				
			} catch (IllegalArgumentException e) {
				
				/* RESPONSE HANDLING */
				
				//Der Controller kann keine Speise identifizieren, benachrichtigt den Benutzer und führt ihn zur der Homepage.
				messenger.setMessage(Messenger.EVAL_ERROR);
				response.sendRedirect("jsp/messaging.jsp?direct=index");
				
				e.printStackTrace();
			}
			
		}else{
			/* RESPONSE HANDLING */
			
			//Der Controller benachrichtigt einen Fehler
			messenger.setMessage(Messenger.ERROR);
			response.sendRedirect("jsp/messaging.jsp?direct=features");
		}	

	}

}
