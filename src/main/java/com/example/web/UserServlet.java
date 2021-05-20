package com.example.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserCollection userCollection = UserCollection.getInstance();
	User user;
	int userID;
	
    public UserServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		//userID = (int) session.getAttribute("loginUserID");
		user = (User) session.getAttribute("loginUser");
		//user = new User("", "");
		//user.setId(userID);
		
		if(userCollection.checkForIDMatch(user) != null) {
			user = userCollection.checkForIDMatch(user);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/EditProfilePage.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personalName = request.getParameter("personalName");
		String job = request.getParameter("job");
		String description = request.getParameter("description");
		
		ArrayList<Skills> proSkills = new ArrayList<Skills>();
		User.addProSkills(proSkills);
		int i = 0;
		for(String strProSkill : request.getParameterValues("proSkillLevel")) {
			proSkills.get(i).setSkillLevel(Integer.parseInt(strProSkill));
			i++;
		}
		
		ArrayList<Skills> personalSkills = new ArrayList<Skills>();
		User.addPersonalSkills(personalSkills);
		i = 0;
		for(String strPersonalSkill : request.getParameterValues("personalSkillLevel")) {
			personalSkills.get(i).setSkillLevel(Integer.parseInt(strPersonalSkill));
			i++;
		}
		
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		
		Address address = new Address(city, street);
		
		user.setDetails(personalName, job, description, proSkills, personalSkills, email, phone, address);
		request.getSession().setAttribute("loginUser", user);
	}

}
