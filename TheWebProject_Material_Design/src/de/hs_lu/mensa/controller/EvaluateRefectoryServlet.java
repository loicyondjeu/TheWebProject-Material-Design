package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hs_lu.mensa.model.RefectoryEvaluation;

/**
 * Servlet implementation class EvaluateRefectoryServlet
 */
@WebServlet("/evaluateRefectory")
public class EvaluateRefectoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Handle Request
		Integer quality = Integer.parseInt(request.getParameter("quality"));
		Integer diversity = Integer.parseInt(request.getParameter("diversity"));
		Integer variety = Integer.parseInt(request.getParameter("variety"));
		Integer serving_size = Integer.parseInt(request.getParameter("serving_size"));
		Date today = new Date();
		
		
		//Handle Bean
		RefectoryEvaluation refectoryEvaluation = new RefectoryEvaluation();
		refectoryEvaluation.setQuality(quality);
		refectoryEvaluation.setDiversity(diversity);
		refectoryEvaluation.setVariety(variety);
		refectoryEvaluation.setServing_size(serving_size);
		refectoryEvaluation.setDay(today);
		
		//Handle Database
		refectoryEvaluation.persist();
		
		//Handle Response
		response.setContentType("text/html;charset=UTF-8");
		final PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("Evaluation wurde am" + refectoryEvaluation.getDay() + " erfolgreich gespeichert \n");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
	}

}
