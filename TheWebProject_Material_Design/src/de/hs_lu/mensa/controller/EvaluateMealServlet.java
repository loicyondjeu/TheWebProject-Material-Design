package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hs_lu.mensa.model.MealEvaluation;

/**
 * Servlet implementation class EvaluateMealServlet
 */
@WebServlet("/evaluateMeal")
public class EvaluateMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Handle Request
		Long meal_id = Long.parseLong(request.getParameter("meal_id"));
		Integer stars = Integer.parseInt(request.getParameter("stars"));
		String emoticon = request.getParameter("emoticon");
		String comment = request.getParameter("comment");
		Date today = new Date();
		
		//Handle Bean
		MealEvaluation mealEvaluation = new MealEvaluation();
		mealEvaluation.setMeal_id(meal_id);
		mealEvaluation.setStars(stars);
		mealEvaluation.setEmoticon(emoticon);
		mealEvaluation.setComment(comment);
		mealEvaluation.setDay(today);
		
		//Handle Database
		mealEvaluation.persist();
		
		//Handle Response
		response.setContentType("text/html;charset=UTF-8");
		final PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("Evaluation wurde am " + mealEvaluation.getDay() + " erfolgreich gespeichert \n");
		out.println("</body>");
		out.println("</html>");
		
	}

}
