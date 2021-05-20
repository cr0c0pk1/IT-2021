package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loginUser") == null) {
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
		} else {
			response.sendRedirect(response.encodeRedirectURL("profile.jsp"));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User newUser = new User();
		newUser.setName(name);
		newUser.setUsername(username);
		newUser.setPassword(password);

		UserCollection userCollection = UserCollection.getInstance();
		
		if(userCollection.checkIfUsernameExists(newUser)) {
			request.setAttribute("existingUser", "existing_user");
			request.getRequestDispatcher("/reg.jsp").include(request, response);
		}
		else {
			userCollection.addUser(newUser);
			//request.getSession().setAttribute("newUser", newUser);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
