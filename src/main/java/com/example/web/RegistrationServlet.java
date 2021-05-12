package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		/*ArrayList<Skills> proSkills = new ArrayList<Skills>();
		proSkills.add(new Skills("HTML", 15));
		proSkills.add(new Skills("CSS", 30));
		
		ArrayList<Skills> personalSkills = new ArrayList<Skills>();
		personalSkills.add(new Skills("Communicativeness", 20));
		personalSkills.add(new Skills("Teamwork", 80));
		
		User newUser = new User(name, username, password, "exjob", "exdescription", 
				proSkills, personalSkills, "exemail", "exphone", 
				new Address("excity", "exstreet"));*/
		
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
			request.getSession().setAttribute("newUser", newUser);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
