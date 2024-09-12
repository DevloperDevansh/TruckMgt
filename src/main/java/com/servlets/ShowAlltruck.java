package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.dao.TruckService;
import com.entities.Truck;

/**
 * Servlet implementation class ShowAlltruck
 */
public class ShowAlltruck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAlltruck() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		
		try {
			List<Truck> allTruck = TruckService.getAllTruck();
			

            pw.println("<html><body>");
            pw.println("<h2>List of All Trucks</h2>");
            pw.println("<table border='1'><tr><th>Truck ID</th><th>Truck Name</th><th>Capacity</th><th>Truck Number</th><th>Action</th></tr>");

            // Loop through the list of trucks and print each one in a table row
            for (Truck truck : allTruck) {
                pw.println("<tr>");
                pw.println("<td>" + truck.getTruckId() + "</td>");
                pw.println("<td>" + truck.getTruckName() + "</td>");
                pw.println("<td>" + truck.getCapacity() + "</td>");
                pw.println("<td>" + truck.getTruckNumber() + "</td>");
                
                
                // Adding Edit and Delete buttons with links to servlets for actions
                pw.println("<td>");
                pw.println("<a href='editTruck?truckId=" + truck.getTruckId() + "'>Edit</a> | ");
                pw.println("<a href='deleteTruck?truckId=" + truck.getTruckId() + "' onclick='return confirm(\"Are you sure you want to delete this truck?\")'>Delete</a>");
                pw.println("</td>");
                
                pw.println("</tr>");
            }

            pw.println("</table>");
            pw.println("</body></html>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
