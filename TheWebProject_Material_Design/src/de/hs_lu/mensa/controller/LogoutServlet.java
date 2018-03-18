package de.hs_lu.mensa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.hs_lu.mensa.helpers.Messenger;
import de.hs_lu.mensa.helpers.SessionManager;
import de.hs_lu.mensa.model.User;

/**
 * Der Controller meldet den in der Session angemeldeten Benutzer ab.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			/* REQUEST HANDLING */
			request.setCharacterEncoding("UTF-8");
			
			/* SESSION HANDLING */
			
			//GET User Data from Session
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			Messenger messenger = SessionManager.getSessionMessenger(session);
			
			//REMOVE user from session
			  /*DEBUG*/System.out.println("Der Benutzer " + user.getUsername() + " wird abgemeldet...");
			session.removeAttribute("user");
			  /*DEBUG*/System.out.println("Der Benutzer " + user.getUsername() + " wurde abgemeldet");
			
			/* RESPONSE HANDLING */
			messenger.setMessage(Messenger.LOGOUT_SUCCESS);
			response.sendRedirect("jsp/messaging.jsp?direct=signin");
		} catch (Exception e) {
			response.sendRedirect("jsp/signin.jsp");
		}
	}

}
