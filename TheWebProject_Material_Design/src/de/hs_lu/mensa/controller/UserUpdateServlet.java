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
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/userUpdate")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Handle Session
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Messenger messenger = SessionManager.getSessionMessenger(session);
		
		//Handle Resquest
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String old_password = request.getParameter("old_password");
		String new_password = request.getParameter("new_password");
		
		//Handle Bean
		if(old_password.equals(user.getPassword())){
			User old_user = new User();
			
			old_user.setUsername(user.getUsername());
			old_user.setPassword(user.getPassword());
			old_user.setEmail(user.getEmail());

			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(new_password);
			
			user.mongoUpdate(old_user);
			
			
			messenger.setMessage(Messenger.UPDATE_OK);
			response.sendRedirect("jsp/messaging.jsp?direct=profile");
			
		}else{
			
			messenger.setMessage(Messenger.UPDATE_FAILED);
			response.sendRedirect("jsp/messaging.jsp?direct=profile");
		}
		
	}

}
