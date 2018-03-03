package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hs_lu.mensa.model.Meal;

/**
 * Servlet implementation class CreateMealServlet
 */
@WebServlet("/createMeal")
public class CreateMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Handle Request
		String name = request.getParameter("name");
		String entree = request.getParameter("entree");
		Boolean vegetarian = request.getParameter("vegetarian") == null ? false : true;
		String description = request.getParameter("description");
		Double energy = Double.valueOf(request.getParameter("energy"));
		
		ArrayList<String> vitamins =  new ArrayList<String>();
		for (int i = 1; i < 6; i++)
			vitamins.add(request.getParameter("v"+i));
		String allergies = request.getParameter("allergies");
		
		//Handle Bean
		Meal meal = new Meal();
		meal.setName(name);
		meal.setEntree(entree);
		meal.setVegetarian(vegetarian);
		meal.setDescription(description);
		meal.setEnergy(energy);
		meal.setVitamins(vitamins);
		meal.setAllergies(allergies);
		
		//Handle database
		meal.persist();
		
		//Handle Response
		response.setContentType("text/html;charset=UTF-8");
		final PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("Die Speise " + meal.getName() + " ist erfolgreich gespeichert");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}