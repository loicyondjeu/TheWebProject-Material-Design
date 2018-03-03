package de.hs_lu.mensa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.hs_lu.mensa.model.MealPlan;

/**
 * Servlet implementation class PlanMealsServlet
 */
@WebServlet("/planMeals")
public class PlanMealsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Handle Request
		Integer weekNum = Integer.parseInt(request.getParameter("weekNum"));
		Integer year = Integer.parseInt(request.getParameter("year"));
//		String day = request.getParameter("day");
//		String type = request.getParameter("type");
//		String submit = request.getParameter("submit");
		
		//Handle Bean
		MealPlan mealPlan = new MealPlan();
		mealPlan.setYear(year);
		mealPlan.setWeekNum(weekNum);
		
		//Handle Session
		HttpSession session = request.getSession();
		session.setAttribute("mealPlan", mealPlan);
		session.setAttribute("giveMeal", true);
		
		//Handle Response
		request.getRequestDispatcher("/findMeal")
			   .forward(request, response);
		
		
	}

}
