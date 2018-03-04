package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hs_lu.mensa.model.Meal;
import de.hs_lu_mensa_dataaccess.MealsODM;

/**
 * Servlet implementation class findMealServlet
 */
@WebServlet("/findMeal")
public class FindMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean giveMeal = (boolean)request.getSession().getAttribute("giveMeal");
		
		if (giveMeal){
			request.getRequestDispatcher("jsp/findMeal.jsp")
				   .forward(request, response);
		}
		
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
