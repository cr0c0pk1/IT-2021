package com.example.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user;
	HttpSession session;
      
    public ProfileServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(false);
	
		Cookie[] cookies = request.getCookies();
		boolean cookieExists = false;
		
		if (session == null || session.getAttribute("loginUser") == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			if (cookies != null) {
				user = (User) session.getAttribute("loginUser");
				for (Cookie cookie : cookies) {
					if((cookie.getName().equals("visitor" + user.getId())) && cookie.getValue().equals("yes")) {
						cookieExists = true;
						break;
					}
				}
			}
		}
		if(cookieExists) {
			response.sendRedirect(response.encodeRedirectURL("profile.jsp"));
		} else {
			request.setAttribute("firstTimeVisitor", "visitor");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if (request.getParameter("btnLogout") != null && session != null) {
			session = request.getSession(false);
			session.invalidate();
			response.sendRedirect("LoginServlet");
		}
		else if (request.getParameter("btnTurnOff") != null) {
			user = (User) session.getAttribute("loginUser");
			Cookie cookie = new Cookie("visitor" + user.getId(), "yes");
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			response.sendRedirect("ProfileServlet");
		}
	}

}
