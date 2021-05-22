<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <%@ page isELIgnored="false"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/myjs.js"></script> 
    <title>Reg</title>
</head>
<body>
	<header class="paded" id="buttonHeader">
		<c:if test="${empty loginUser}">
    		<input id="headerButton" type="button" value="Вход" onclick="redirect('LoginServlet')">
			<input id="headerButton" type="button" value="Регистрация" onclick="redirect('RegistrationServlet')">
		</c:if>	
		<input id="headerButton" type="button" value="Изход">
	</header>
    <div id="outerDiv">
    	<% if("existing_user".equals(request.getAttribute("existingUser"))) { %>
			<h3 style="color: red; text-align: center;">Потребителят вече е регистриран!</h3>
		<% } %>
        <h2>Създаване на профил</h2>
        <div id="innerDiv">
            <form action="RegistrationServlet" method="post">
                <p id="name">Име: </p>
                <div class="paded">
                    <input type="text" name="name" placeholder="Въведете име за контакт" required>
                </div> 
                <p class="inputLabels">Потребителско име:</p>
                <div class="paded">
                    <input type="text" name="username" placeholder="Въведете потребителско име" required>
                </div>
                <p class="inputLabels">Парола:</p>
                <div class="paded">
                    <input type="text" name="password" placeholder="Въведете парола поне с 8 символа" required>
                </div>
                <p class="inputLabels">Повторете паролата:</p>
                <div class="paded">
                    <input type="text" name="confirmPasssword" placeholder="Въведете парола поне с 8 символа" required>
                </div>
                <div class="paded" id="buttonDiv">
                    <button type="submit" value="Submit" id="loginButton">Вход</button>
                </div>        
            </form>
        </div>
    </div>
</body>
</html>