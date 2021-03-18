package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User newUser = new User(name, username, password);
		
		UserCollection userCollection = UserCollection.getInstance();
		
		if(userCollection.checkIfUserExists(newUser)) {
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
			out.println("<h1>Username exists</h1>");
		}
		else {
			userCollection.addUser(newUser);
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
	}

}
