package com.example.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public AllUsersServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserCollection userCollection = UserCollection.getInstance();
		
		if(userCollection.getUsers().isEmpty()) {
			request.setAttribute("emptyCollection", true);
			request.getRequestDispatcher("/users.jsp").forward(request, response);
		} else {
			request.setAttribute("userCollection", userCollection.getUsers());
			request.getRequestDispatcher("/users.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
