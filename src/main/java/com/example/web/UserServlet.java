package com.example.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		int userID = (int) session.getAttribute("loginUserID");
		
		UserCollection userCollection = UserCollection.getInstance();
		
		User user = new User("a", "a");
		user.setId(userID);
		
		if(userCollection.checkForIDMatch(user) != null) {
			user = userCollection.checkForIDMatch(user);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/EditProfilePage.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
