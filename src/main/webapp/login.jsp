<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Login</title>
</head>
<body>
    <div id="outerDiv">
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