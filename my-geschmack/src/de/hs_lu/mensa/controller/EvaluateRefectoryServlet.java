package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hs_lu.mensa.helpers.Denullyfier;
import de.hs_lu.mensa.helpers.Messenger;
import de.hs_lu.mensa.helpers.SessionManager;
import de.hs_lu.mensa.model.RefectoryEvaluation;
import de.hs_lu_mensa_dataaccess.MongoTester;

/**
 * Dieser Controller übernimmt die Aufgabe zur Speicherung einer Bewertung der Mensa in der Datenbank.
 */
@WebServlet("/evaluateRefectory")
public class EvaluateRefectoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* SESSION HANDLING */
		Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
		
		
		/* REQUEST HANDLING */
		request.setCharacterEncoding("UTF-8");
		
		Integer quality = Integer.valueOf(Denullyfier.denullifyInteger(request.getParameter("quality")));
		Integer diversity = Integer.valueOf(Denullyfier.denullifyInteger(request.getParameter("diversity")) );
		Integer variety = Integer.valueOf(Denullyfier.denullifyInteger(request.getParameter("variety")));
		Integer serving_size = Integer.valueOf(Denullyfier.denullifyInteger(request.getParameter("serving_size")));
		Date today = new Date();
		
		 //AKTION PRÜFUNG
		String bewerten = request.getParameter("bewerten");

		if(bewerten.equals("bewerten")){
			
			/* BEAN HANDLING */
			//Da Alle Daten aus dem Resquest sauber gelesen worden sind, erzeugt der Controller ein Objekt Speise
			RefectoryEvaluation eval = new RefectoryEvaluation();
			
			eval.setDiversity(diversity);
			eval.setQuality(quality);
			eval.setServing_size(serving_size);
			eval.setVariety(variety);
			eval.setDate(today);
			
			if(MongoTester.testMongo()){
				
				eval.mongoWrite();
				
				/* RESPONSE HANDLING */			
				
				messenger.setMessage(Messenger.THANKS_FOR_EVAL);
				response.sendRedirect("jsp/messaging.jsp?direct=evaluateRefectory");
				
			}else{
				
				/* RESPONSE HANDLING */
				
				//Der Controller benachrichtigt den User für den Ausfall der Datenbank und führt zur der Anmelde Seite.
				messenger.setMessage(Messenger.MONGO_ERROR);
				response.sendRedirect("jsp/messaging.jsp?direct=signin");				
			}			
			
		}else{
			/* RESPONSE HANDLING */
			
			//Der Controller benachrichtigt einen Fehler
			messenger.setMessage(Messenger.ERROR);
			response.sendRedirect("jsp/messaging.jsp?direct=evaluateRefectory");
		}
		
	}

}
