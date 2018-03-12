package de.hs_lu.mensa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hs_lu.mensa.helpers.Messenger;
import de.hs_lu.mensa.helpers.SessionManager;
import de.hs_lu.mensa.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Handle Request
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String function = request.getParameter("function");
		//String submit = request.getParameter("submit");
		
		//Handle Bean
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setSex(sex);
		user.setFunction(function);
		
		//Handle Database
		user.mongoWrite();
		
		//Handle Response
		Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
		messenger.setMessage(Messenger.CREATE_USER_OK);
		response.sendRedirect("jsp/messaging.jsp?direct=register");


	}

}
