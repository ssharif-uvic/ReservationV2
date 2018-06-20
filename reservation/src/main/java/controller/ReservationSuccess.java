package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReservationSuccess extends HttpServlet {

	private static final long serialVersionUID = 8600923440194787075L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		writer.println("<html>" + "<body>" + "<center>"
				+ "Reservation made successfully" + "</center>" + 
				
	"<form action=\"/reservation/controller\" method=\"post\">" +
				"<input type=\"hidden\" name=\"requestType\" value=\"listReservations\">" +
				"<input type=\"submit\" value=\"List Reservations\"  ></form>" +
				 "</body> </html>");
	}

}
