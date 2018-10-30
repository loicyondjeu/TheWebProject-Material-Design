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
import de.hs_lu_mensa_dataaccess.MongoTester;

/**
 * Servlet implementation class SigninServlet
 */
@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/* REQUEST HANDLING */
		
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		/* Keine Aktionsprüfung da einzige Aktion Anmelden ist */ 
		
		/* BEAN HANDLING */
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		/* SESSION HANDLING */
		
		Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
		
		
		/* DATENBANK HANDLING */
		
		//Der Controller testet ob eine Datenbank verbindung liegt
		if(MongoTester.testMongo()){	
			
			if(user.mongoRead()){
				//Handle Response
				//Initializing Session and user
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("jsp/features.jsp");
			}else{
				messenger.setMessage(Messenger.LOGIN_FAILED);
				response.sendRedirect("jsp/messaging.jsp?direct=signin");
			}
			
		}else{
			
			/* RESPONSE HANDLING */
			
			//Der Controller benachrichtigt den User für den Ausfall der Datenbank und führt zur der Anmelde Seite.
			messenger.setMessage(Messenger.MONGO_ERROR);
			response.sendRedirect("jsp/messaging.jsp?direct=signin");
			
		}
		


	}

}
