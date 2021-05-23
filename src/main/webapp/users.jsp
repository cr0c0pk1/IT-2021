<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style_index.css">
    <script src="js/myjs.js"></script> 
	<title>Users</title>
</head>
<body>
	<div class="header" id = "buttonHeader">
		<c:if test="${empty loginUser}">
			<input id="headerButton" type="button" value="Вход" onclick="redirect('LoginServlet')">
			<input id="headerButton" type="button" value="Регистрация" onclick="redirect('RegistrationServlet')">		
		</c:if>
		<form action="ProfileServlet" method="post" id="headerButton">
			<input id="headerButton" type="button" name="btnLogout" value="Изход">
		</form>
		<input id="headerButton" type="button" value="Потребители" onclick="redirect('AllUsersServlet')">
    </div>
    <div class="grayDiv">
        <div class="centeredDiv">
        	<c:if test="${emptyCollection }">
        		<h1 style="color: red;">Няма потребители</h1>
			</c:if>
			<table border="1">
                <tr>
                    <th>Потребител</th>
                    <th>Работа</th>
                    <th>Информация</th>
                </tr>
                	<c:forEach var="user" items="${requestScope.userCollection}">
                		<tr>
                    		<td>
                    			<c:if test="${not empty loginUser}">
                    				<a href="ProfileServlet"><c:out value="${user.getName()}"/></a>
                    			</c:if>
                    			<c:if test="${empty loginUser}">
                    				<c:out value="${user.getName()}"/>
                    			</c:if>
                    		</td>
                    		<td><c:out value="${user.getJob()}"/></td>
                    		<td><c:out value="${user.getDescription()}"/></td>
                		</tr>
                	</c:forEach>
           	</table>
        </div>
    </div>
</body>
</html>