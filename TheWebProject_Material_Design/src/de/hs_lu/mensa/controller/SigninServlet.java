package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		//Handle Database
		user.lookup();
		
		//Handle Response
		response.setContentType("text/html;charset=UTF-8");
		final PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("Der Benutzer " + user.getUsername() + " ist erfolgreich angemeldet <br/> \n");
		out.println("Passwort: " + user.getPassword() + " <br/>  \n");
		out.println("Email: " + user.getEmail() + " <br/>  \n");
		out.println("Geschlecht: " + user.getSex() + " <br/>  \n");
		out.println("Funktion: " + user.getFunction());
		out.println("</body>");
		out.println("</html>");
	}

}
