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
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//GET User Data from Session
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		//REMOVE user from session
		System.out.println("Der Benutzer " + user.getUsername() + " wird abgemeldet...");
		session.removeAttribute("user");
		System.out.println("Der Benutzer " + user.getUsername() + " wurde abgemeldet");
		
		//RESPONSE
		Messenger messenger = SessionManager.getSessionMessenger(session);
		messenger.setMessage(Messenger.LOGOUT_SUCCESS);
		response.sendRedirect("jsp/messaging.jsp?direct=signin");
	}

}
