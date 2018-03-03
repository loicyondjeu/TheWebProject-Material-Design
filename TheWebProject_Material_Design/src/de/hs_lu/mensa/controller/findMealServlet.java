package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import de.hs_lu.mensa.model.Meal;
import de.hs_lu_mensa_dataaccess.MealsODM;
import de.hs_lu_mensa_dataaccess.MongoConnection;

/**
 * Servlet implementation class findMealServlet
 */
@WebServlet("/findMeal")
public class findMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	request.setAttribute("test", "Blablablablalbalbabla");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Meal>meals;
		MealsODM odm;
		String name = request.getParameter("name");
		String vegetarian = request.getParameter("vegetarian");
		String avg_eval = request.getParameter("avg_eval");
		String calories = request.getParameter("calories");
		String submit = request.getParameter("submit");
		/*PrintWriter out = response.getWriter();
		out.println("\nName: " + name );
		out.println("Note: " + avg_eval );
		out.println( "Vegetarian:" + vegetarian);
		out.println("Kalories: " + calories);*/
		if(submit != null)
		{ 	
			odm=new MealsODM();
			meals=odm.getMeals(name, avg_eval, (vegetarian!=null), calories);
			System.out.println(meals.size());
			request.setAttribute("meals", meals);
			request.setAttribute("submit", submit);
			
		}
	
		request.getRequestDispatcher("jsp/findMeal.jsp").forward(request, response);
		

	}

}
