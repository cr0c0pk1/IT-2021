package com.example.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String loginUsername = request.getParameter("loginUsername");
		String loginPass = request.getParameter("loginPass");
		
		User newUser = new User();
		newUser.setUsername(loginUsername);
		newUser.setPassword(loginPass);
		
		UserCollection userCollection = UserCollection.getInstance();
		
		if(userCollection.checkIfUserExists(newUser)) {
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
