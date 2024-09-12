package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.connectionprovider.Connectiondetails;
import com.dao.TruckService;
import com.entities.Truck;

/**
 * Servlet implementation class AddTruckServlet
 */
public class AddTruckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTruckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Fetch truck details from the form
		String truckName = request.getParameter("truckName");
		String capacity = request.getParameter("capacity");
		String truckNumber = request.getParameter("truckNumber");
		
		//create truck object for passing truck details
		Truck truck = new Truck(truckName, truckNumber, capacity);
		
		try {
			boolean res = TruckService.addTruck(truck);
			PrintWriter pw = response.getWriter();;
			if(res) {
				
				pw.println("<h1>Truck details added successfully</h1>");
				response.sendRedirect("Admindashboard.html");
			}else {
				pw.println("<h1>Something went wrong!!</h1>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
