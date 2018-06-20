package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccessLayer.UserDAO;
import model.Destination;
import model.Person;
import model.Reservation;
import model.ReservationStatus;
import model.UserType;

/**
 * Servlet implementation class UserActionControllerServlet
 */
public class UserActionControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserActionControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String requestType = request.getParameter("requestType");

            switch (requestType) {
            case "addReservation":
                addReservation(request, response);
                break;
            case "listReservations":
            	listReservation(request, response);
                break;
            case "newReservations":
            	newReservation(request, response);
                break;
            case "processReservation":
            	processReservation(request, response);
                break;
            default:
            	newReservation(request, response);
                break;
            }
	}

	private void processReservation(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Reservation> reservations = (ArrayList<Reservation>) request.getSession().getAttribute("reservations");
		String SelectedIdStr = request.getParameter("selection");
		int selectedId = Integer.parseInt(SelectedIdStr);
		Reservation selectedReservation = reservations.stream()
                .filter((p) -> selectedId == p.getReservationId())
                .findAny()
                .orElse(null);
		if (selectedReservation != null) 
			selectedReservation.setReservationStatus(ReservationStatus.RESERVED);
			UserDAO userDao = new UserDAO();
			userDao.updateReservation(selectedReservation);
		try {
			response.sendRedirect("Success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void newReservation(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("/reservation/reservation.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void listReservation(HttpServletRequest request, HttpServletResponse response) {
		try {
			UserDAO userDAO = new UserDAO();
			List<Reservation> reservations = userDAO.getReservations();
			request.getSession().setAttribute("reservations", reservations);
			/*request.getSession().setAttribute("person", new Person("aaaaaa","bbbbbbb",UserType.CUSTOMER));
			request.getSession().setAttribute("a", "5");*/
			
			request.getRequestDispatcher("/listReservations.jsp").forward(request, response);
			
			//response.sendRedirect("/reservation/listReservations.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ServletException e) {
			e.printStackTrace();
		}
		
	}

	private void addReservation(HttpServletRequest request, HttpServletResponse response) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String airport = request.getParameter("airport");
		String travelDateStr = request.getParameter("travelDate");		

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		Date travelDate = null;
		try {
			travelDate = sdf.parse(travelDateStr);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Reservation reservation = new Reservation(new Person(firstName, lastName, UserType.CUSTOMER), new Destination(country, city,
					airport), travelDate, ReservationStatus.NEW);
					
			UserDAO userDAO = new UserDAO();
			userDAO.addReservation(reservation);
			response.sendRedirect("Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
