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
import de.hs_lu.mensa.model.MealEvaluation;
import de.hs_lu_mensa_dataaccess.MongoTester;

/**
 * der Controller SaveMealEvaluationServlet ist verantwortlich für die Speicherung der Bewertungen einer Speise von den Gästen.
 * 
 */
@WebServlet("/saveMealEvaluation")
public class SaveMealEvaluationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*REQUEST HANDLING*/
		request.setCharacterEncoding("UTF-8");
		
		Integer freshness = Integer.valueOf(Denullyfier.denullifyInteger(request.getParameter("freshness")));
		Integer serving_size = Integer.valueOf(Denullyfier.denullifyInteger(request.getParameter("serving_size")));
		Integer taste = Integer.valueOf(Denullyfier.denullifyInteger(request.getParameter("taste")));
		String comment = Denullyfier.denullifyString(request.getParameter("comment"));
		
		
		ObjectId evaluatedMeal_id;
		try {
			evaluatedMeal_id = new ObjectId(Denullyfier.denullifyString(request.getParameter("evaluated")));
			
			/* BEAN HANDLING */
			//Da Alle Daten aus dem Resquest sauber gelesen worden sind, erzeugt der Controller ein Objekt Speise

			MealEvaluation mealEvaluation = new MealEvaluation();
			
			mealEvaluation.setMeal_id(evaluatedMeal_id);
			mealEvaluation.setFreshness(freshness);
			mealEvaluation.setServing_size(serving_size);
			mealEvaluation.setTaste(taste);
			mealEvaluation.setComment(comment);
			
			/* DATENBANK HANDLING */
			
			//Der Controller testet ob eine Datenbank verbindung liegt
			if(MongoTester.testMongo()){
				
				mealEvaluation.mongoWrite();
				
				/* RESPONSE HANDLING */
				
				//Der Controller benachrichtigt den User für den Erfolg der Datenbank und führt zur homepage.				
				Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
				messenger.setMessage(Messenger.THANKS_FOR_EVAL);
				response.sendRedirect("jsp/messaging.jsp?direct=index");
				
			}else{
				
				/* RESPONSE HANDLING */
				
				//Der Controller benachrichtigt den User für den Ausfall der Datenbank und führt zur der Anmelde Seite.
				Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
				messenger.setMessage(Messenger.MONGO_ERROR);
				response.sendRedirect("jsp/messaging.jsp?direct=signin");
				
			}
			
		} catch (IllegalArgumentException e) {
			
			/* RESPONSE HANDLING */
			
			//Der Controller kann keine Speise identifizieren, benachrichtigt den Benutzer und führt ihn zur der Homepage.
			Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
			messenger.setMessage(Messenger.EVAL_ERROR);
			response.sendRedirect("jsp/messaging.jsp?direct=index");
			
			e.printStackTrace();
		}
		
	}

}
