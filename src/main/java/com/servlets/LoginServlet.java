package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connectionprovider.Connectiondetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch the details from the html form
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String sql = "select * from login where username=? AND password = ?";

		try {
			PreparedStatement ps = Connectiondetails.getconnection().prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			PrintWriter pw = response.getWriter();

			response.setContentType("text/html");

			// Check if user exists
			if (rs.next()) {
				// Login successful
				pw.println("<h3>Login Successful! Welcome, " + username + ".</h3>");
				response.sendRedirect("Admindashboard.html");
				// You can redirect to a different page or provide more information here
			} else {
				// Login failed
				pw.println("<h3>Invalid username or password. Please try again.</h3>");
				// You could also redirect to the login page again
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
