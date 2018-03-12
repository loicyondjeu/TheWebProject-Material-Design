package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hs_lu.mensa.helpers.Messenger;
import de.hs_lu.mensa.helpers.SessionManager;
import de.hs_lu.mensa.model.RefectoryEvaluation;

/**
 * Servlet implementation class EvaluateRefectoryServlet
 */
@WebServlet("/evaluateRefectory")
public class EvaluateRefectoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
		
		Integer quality = Integer.valueOf(request.getParameter("quality"));
		Integer diversity = Integer.valueOf(request.getParameter("diversity"));
		Integer variety = Integer.valueOf(request.getParameter("variety"));
		Integer serving_size = Integer.valueOf(request.getParameter("serving_size"));
		Date today = new Date();
		String bewerten = request.getParameter("bewerten");

		if(bewerten.equals("bewerten")){
			RefectoryEvaluation eval = new RefectoryEvaluation();
			
			eval.setDiversity(diversity);
			eval.setQuality(quality);
			eval.setServing_size(serving_size);
			eval.setVariety(variety);
			eval.setDate(today);
			
			eval.mongoWrite();

			messenger.setMessage(Messenger.THANKS_FOR_EVAL);
			response.sendRedirect("jsp/messaging.jsp?direct=evaluateRefectory");
			
		}else{
			messenger.setMessage(Messenger.ERROR);
			response.sendRedirect("jsp/messaging.jsp?direct=evaluateRefectory");
		}
		
	}

}
