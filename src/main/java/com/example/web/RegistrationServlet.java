package com.example.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
			response.sendRedirect(response.encodeRedirectURL("ProfileServlet"));
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
		
		/*try {
			marshal(newUser);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		UserStorageMarshalling userStorage = new UserStorageMarshalling();
		UserCollection userCollection = UserCollection.getInstance();
		
		try {
			userStorage = unmarshal("D:\\eclipse_developer\\users.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(User unmarshalUser : userStorage.getUserStorage()) {
			userCollection.addUser(unmarshalUser);
		}
		
		if(userCollection.checkIfUsernameExists(newUser)) {
			request.setAttribute("existingUser", "existing_user");
			request.getRequestDispatcher("/reg.jsp").include(request, response);
		}
		else {
			userCollection.addUser(newUser);
			userStorage.addUser(newUser);
			
			try {
				JAXBContext context = JAXBContext.newInstance(UserStorageMarshalling.class);
				Marshaller mar = context.createMarshaller();
				mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				mar.marshal(userStorage, new File("./users.xml"));
			} catch(JAXBException e) {
				e.printStackTrace();
			}
			
			//request.getSession().setAttribute("newUser", newUser);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	public void marshal(User user) throws JAXBException {
		UserStorageMarshalling userStorage = new UserStorageMarshalling();
		
		User user1 = new User("Name1", "Username1", "Password1", "Job1", "Description1", user.getProSkills(), 
				user.getPersonalSkills(), "email1", "phone1", new Address("City1", "Street1"));
		user1.setId(997);
		
		userStorage.addUser(user1);
		
		User user2 = new User("Name2", "Username2", "Password2", "Job2", "Description2", user.getProSkills(), 
				user.getPersonalSkills(), "email2", "phone2", new Address("City2", "Street2"));
		user2.setId(998);
		
		userStorage.addUser(user2);
		
		User user3 = new User("Name3", "Username3", "Password3", "Job3", "Description3", user.getProSkills(), 
				user.getPersonalSkills(), "email3", "phone3", new Address("City3", "Street3"));
		user3.setId(999);
		
		userStorage.addUser(user3);
		
		JAXBContext context = JAXBContext.newInstance(UserStorageMarshalling.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(userStorage, new File("./users.xml"));
	}
	
	public UserStorageMarshalling unmarshal(String xmlFile) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(UserStorageMarshalling.class);
		Unmarshaller um = context.createUnmarshaller();
		UserStorageMarshalling userStorage = (UserStorageMarshalling) um.unmarshal(new FileReader(xmlFile));
		return userStorage;
	}

}
