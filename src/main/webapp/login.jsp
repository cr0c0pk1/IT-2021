<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/myjs.js"></script> 
    <title>Login</title>
</head>
<body>
	<header class = "paded" id = "buttonHeader">
		<c:if test="${empty loginUser}">
    		<input id="headerButton" type="button" value="Вход" onclick="redirect('LoginServlet')">
			<input id="headerButton" type="button" value="Регистрация" onclick="redirect('RegistrationServlet')">
		</c:if>		
		<input id="headerButton" type="button" value="Изход">
	</header>
    <div id="outerDiv">
    	<% if("wrong_creds".equals(request.getAttribute("wrongCreds"))) { %>
			<h3 style="color: red; text-align: center;">Грешно потребителско име или парола!</h3>
		<% } %>
        <h2>Влезте в системата</h2>
        <div id="innerDiv">
            <form action="LoginServlet" method="post">
                <p class="inputLabels">Потребителско име:</p>
                <div class="paded">
                    <input type="text" name="loginUsername" placeholder="Въведете потребителско име">
                </div>
                <p class="inputLabels">Парола:</p>
                <div class="paded">
                    <input type="text" name="loginPass" placeholder="Въведете парола поне с 8 символа">
                </div>
                <div class="paded" id="buttonDiv">
                    <button type="submit" value="submit" id="loginButton">Вход</button>
                </div>  
            </form>
        </div>
    </div>
</body>
</html>