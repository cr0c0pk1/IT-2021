<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style_index.css">
    <title>index</title>
</head>
<body>
    <div class="header">
    </div>
    <div class="grayDiv">
        <div class="centeredDiv">
        <form action="#" method="post">
            <div class="imgDiv">
                <img src="imgs/male.svg" alt="male">
            </div>
            <div class="profileInfo">
                <h2>Профилна информация</h2>
               	<p>ID: <c:out value="${user.getId()}"></c:out></p>
                <label>Име: </label>
                <br>
                <input type="text" name="personalName" value="${loginUser.getName()}"/>
                <br>
                <label>Работа: </label>
                <br>
                <input type="text" name="job" value="${loginUser.getJob()}"/>
                <br>
                <label>Описание: </label>
                <br>
                <input type="text" name="description" value="${loginUser.getDescription()}"/>
            </div>
            <div class="skillTitleDiv">
                <h2>Умения</h2>
            </div>
            <div class="skills">
                <div class="wrapper">
                    <div class="professionalSkillsDiv">
                        <h3>Професионални</h3>
                        <c:forEach var="proSkill" items="${loginUser.getProSkills()}">
                        	<input type="text" name="proSkill" value="${proSkill.getSkillName()}"/>
                        	<input class="progressBar" type="range" min="0" max="100" step="10" name="proSkillLevel" value="${proSkill.getSkillLevel()}"/>
                        </c:forEach>
                    </div>
                    <div class="personalSkillsDiv">
                        <h3>Личностни</h3>
                        <c:forEach var="personalSkill" items="${loginUser.personalSkills}">
                        	<input type="text" name="personalSkill" value="${personalSkill.getSkillName()}"/>
                        	<input class="progressBar" type="range" min="0" max="100" step="10" name="personalSkillLevel" value="${personalSkill.getSkillLevel()}"/>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="contactsTitle">
                <h2>Контакти</h2>
            </div>
            <div class="contacts">
                <div class="wrapperContacts">
                    <div class="contactsLeft">
                        <p>Имейл</p>
                            <input type="text" name="email" value="${loginUser.getEmail()}"/>
                            <p>Телефон</p>
                            <input type="text" name="phone" value="${loginUser.getPhone()}"/>
                        </div>
                        <div class="contactsRight">
                            <p>Град</p>
                            <input type="text" name="city" value="${loginUser.getAddress().getCity()}"/>
                            <p>Улица</p>
                            <input type="text" name="street" value="${loginUser.getAddress().getStreet()}"/>
                        </div>
                    </div>
            </div>
            <div style="text-align: center;">
                <input id="btnSave" type="submit" value="Запази"/>
            </div>
        </form>
        </div>
    </div>
    <div class="footer">
        
    </div>
</body>
</html>