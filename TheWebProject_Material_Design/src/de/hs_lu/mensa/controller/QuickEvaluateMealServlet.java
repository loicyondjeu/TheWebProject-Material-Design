package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hs_lu.mensa.model.QuickMealEvaluation;

/**
 * Servlet implementation class QuickEvaluateMealServlet
 */
@WebServlet("/quickEvaluateMeal")
public class QuickEvaluateMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Handle Request
		
		String soup = request.getParameter("soup");
		String dessert = request.getParameter("dessert");
		String salad = request.getParameter("salad");
		String entree = request.getParameter("entree");
		String complement = request.getParameter("complement");
		Date today = new Date();
		
		//Handle Bean
		QuickMealEvaluation qMealEvaluation = new QuickMealEvaluation();
		qMealEvaluation.setSoup(soup);
		qMealEvaluation.setSalad(salad);
		qMealEvaluation.setDessert(dessert);
		qMealEvaluation.setEntree(entree);
		qMealEvaluation.setComplement(complement);
		qMealEvaluation.setDay(today);
		
		//Handle Database
		qMealEvaluation.persist();
		
		//Handle Response
		//Handle Response
		response.setContentType("text/html;charset=UTF-8");
		final PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("Schnelle Bewertung gespeichert am " + qMealEvaluation.getDay());
		out.println("</body>");
		out.println("</html>");
	}

}
