package de.hs_lu.mensa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hs_lu.mensa.helpers.Denullyfier;
import de.hs_lu.mensa.helpers.Messenger;
import de.hs_lu.mensa.helpers.SessionManager;
import de.hs_lu.mensa.model.User;
import de.hs_lu_mensa_dataaccess.MongoTester;

/**
 * Der Controller registriert einen User in der Datenbank.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* SESSION HANDLING */
		Messenger messenger = SessionManager.getSessionMessenger(request.getSession());
		
		/*REQUEST HANDLING*/
		
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String function = request.getParameter("function");
		
		boolean submit = Denullyfier.denullifyString(request.getParameter("submit")).equals("anmelden") ? true:false;
		
		
		if(submit){
			
			/* BEAN HANDLING */
			User user = new User();
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);
			user.setSex(sex);
			user.setFunction(function);
			
			/* DATENBANK HANDLING */
			
			//Der Controller testet ob eine Datenbank verbindung liegt
			if(MongoTester.testMongo()){	
				
				user.mongoWrite();
				
				/* RESPONSE HANDLING */
				
				//Der Controller benachrichtigt den User für den Erfolg und führt zurück der Ansicht.
				messenger.setMessage(Messenger.CREATE_USER_OK);
				response.sendRedirect("jsp/messaging.jsp?direct=register");
				
			}else{
				
				/* RESPONSE HANDLING */
				
				//Der Controller benachrichtigt den User für den Ausfall der Datenbank und führt zur der Anmelde Seite.
				messenger.setMessage(Messenger.MONGO_ERROR);
				response.sendRedirect("jsp/messaging.jsp?direct=signin");
				
			}
			
		}else{
			/* RESPONSE HANDLING */
			
			//Der Controller benachrichtigt einen Fehler
			messenger.setMessage(Messenger.ERROR);
			response.sendRedirect("jsp/messaging.jsp?direct=features");
		}

	}

}
