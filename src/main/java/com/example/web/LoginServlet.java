package com.example.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();
		User newUser = (User)session.getAttribute("newUser");
		
		User loginUser = new User(loginUsername, loginPass);
		
		UserCollection userCollection = UserCollection.getInstance();
		
		if(userCollection.checkIfUserExists(loginUser)) {
			/*request.setAttribute("loginUser", loginUser);
			request.getRequestDispatcher("/profile.jsp").forward(request, response);*/
			session.invalidate();
			request.getSession().setAttribute("loginUserID", newUser.getId());
			response.sendRedirect("UserServlet");
		}
		else {
			request.setAttribute("wrongCreds", "wrong_creds");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
