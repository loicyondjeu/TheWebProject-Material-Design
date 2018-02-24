package de.hs_lu.mensa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hs_lu.mensa.model.Ausgabe;
import de.hs_lu.mensa.model.Speise;

/**
 * Servlet implementation class CreateFoodServlet
 */
@WebServlet("/createAusgabe")
public class AusgabeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ausgabetyp = request.getParameter("ausgabetyp");
		String strSuppe = request.getParameter("suppe");
		String strHauptspeise = request.getParameter("hauptspeise");
		String strKomplement = request.getParameter("komplement");
		String strDessert = request.getParameter("dessert");
		String strSalat = request.getParameter("salat");
		
		Speise suppe = new Speise(strSuppe, "suppe");
		Speise hauptspeise = new Speise(strHauptspeise, "hauptspeise");
		Speise komplement = new Speise(strKomplement, "komplement");
		Speise dessert = new Speise(strDessert, "dessert");
		Speise salat = new Speise(strSalat, "salat");
		
		Ausgabe ausgabe = new Ausgabe(ausgabetyp, suppe, hauptspeise, komplement, salat, dessert);
		
		response.setContentType("text/html;charset=UTF-8");
		
		final PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("Daten der Ausgabe: <br>");
		out.println(ausgabe.toString());
		out.println("</body>");
		out.println("</html>");
				
	}

}
