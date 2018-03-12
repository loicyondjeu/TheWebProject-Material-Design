package de.hs_lu.mensa.controller;

import java.io.IOException;
//import java.io.PrintWriter;

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
 * Servlet implementation class SigninServlet
 */
@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Handle Request
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//String submit = request.getParameter("submit");
		
		//Handle Bean
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		//Initializing Session and user
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		//Handle Database
		if(user.mongoRead()){
			//Handle Response
			response.sendRedirect("jsp/features.jsp");
		}else{
			Messenger messenger = SessionManager.getSessionMessenger(session);
			messenger.setMessage(Messenger.LOGIN_FAILED);
			response.sendRedirect("jsp/messaging.jsp?direct=signin");
		}
	}

}
