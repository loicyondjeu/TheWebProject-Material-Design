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

/**
 * Servlet implementation class SaveQuickMealEvaluation
 */
@WebServlet("/saveQuickMealEvaluation")
public class SaveQuickMealEvaluation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String salad = request.getParameter("salad");
		String soup = request.getParameter("soup");
		String dessert = request.getParameter("dessert");
		String entree = request.getParameter("entree");
		String complement = request.getParameter("complement");
		ObjectId meal_id = new ObjectId(request.getParameter("meal"));
		
		String bewerten = Denullyfier.denullifyString(request.getParameter("bewerten"));
		
		System.out.println(bewerten);
		if(bewerten.equals("bewerten")){
			MealQuickEvaluation eval = new MealQuickEvaluation();
			eval.setMeal_id(meal_id);
			eval.setComplement(complement);
			eval.setDessert(dessert);
			eval.setEntree(entree);
			eval.setSalad(salad);
			eval.setSoup(soup);
			
			eval.mongoWrite();
			
			
			Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
			messenger.setMessage(Messenger.THANKS_FOR_EVAL);
			response.sendRedirect("jsp/messaging.jsp?direct=index");
			
		}

	}

}
