package de.hs_lu.mensa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import de.hs_lu.mensa.helpers.Messenger;
import de.hs_lu.mensa.helpers.SessionManager;
import de.hs_lu.mensa.model.MealEvaluation;

/**
 * Servlet implementation class SaveMealEvaluationServlet
 */
@WebServlet("/saveMealEvaluation")
public class SaveMealEvaluationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer freshness = Integer.valueOf( request.getParameter("freshness"));
		Integer serving_size = Integer.valueOf( request.getParameter("serving_size"));
		Integer taste = Integer.valueOf( request.getParameter("taste"));
		String comment = request.getParameter("comment");
		
		ObjectId evaluatedMeal_id = new ObjectId(request.getParameter("evaluated"));
		
		if(evaluatedMeal_id != null){
			MealEvaluation mealEvaluation = new MealEvaluation();
			mealEvaluation.setMeal_id(evaluatedMeal_id);
			mealEvaluation.setFreshness(freshness);
			mealEvaluation.setServing_size(serving_size);
			mealEvaluation.setTaste(taste);
			mealEvaluation.setComment(comment);
			
			mealEvaluation.mongoWrite();
			
			Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
			messenger.setMessage(Messenger.THANKS_FOR_EVAL);
			response.sendRedirect("jsp/messaging.jsp?direct=index");			
			
		}
	}

}
