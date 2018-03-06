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
		
		//Handle Session
		boolean giveMeal = (boolean)request.getSession().getAttribute("giveMeal");
		
		if (giveMeal){
			/*request.getRequestDispatcher("jsp/findMeal.jsp")
				   .forward(request, response);
		*/
		
			
		// Handle Bean	
		List<Meal>meals;
		MealsODM odm;
		
		//Handle Request
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
		
		
		if(submit != null )
			if(submit.equals("suchen")){ 	
			
		//Instantiation 	of ODM
				odm=new MealsODM();
			
		// Call ODM Method getMeals with parameters
				meals=odm.getMeals(name, avg_eval, (vegetarian!=null), calories);
		
		// Sending attribute to jsp		
				request.setAttribute("meals", meals);
				request.setAttribute("submit", submit);
			
		}
		//Handle Response 
		request.getRequestDispatcher("jsp/findMeal.jsp").forward(request, response);
		}
		
		else {
		//if the giveMeal was not given	
			request.getRequestDispatcher("jsp/planMeals.jsp").forward(request, response);
		}
	}

}
