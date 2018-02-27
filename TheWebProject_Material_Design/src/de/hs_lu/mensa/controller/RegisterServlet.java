package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registrieren")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String uri0 = "mongodb://TheWebProject:flamongo@mensaapp-shard-00-00-dyqy3.mongodb.net:27017,mensaapp-shard-00-01-dyqy3.mongodb.net:27017,mensaapp-shard-00-02-dyqy3.mongodb.net:27017/test?ssl=true&replicaSet=MensaApp-shard-0&authSource=admin";
		MongoClientURI uri = new MongoClientURI(uri0);

		// MongoClient für den Zugriff auf die Datenbank
		MongoClient mongoClient = new MongoClient(uri);
		
		MongoDatabase database = mongoClient.getDatabase("MensaBase");
		
		MongoCollection<Document> users = database.getCollection("Users");
		
		
		Document doc = new Document();
		doc.put("username", username);
		doc.put("password", password);
		System.out.println("inserting");
		users.insertOne(doc);
		System.out.println("completed");
		
		final PrintWriter out = response.getWriter();
		
		mongoClient.close();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("Ihre eingegebene Daten:");
		out.println("<br>Username: " + username);
		out.println("</body>");
		out.println("</html>");
	}

}
