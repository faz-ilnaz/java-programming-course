<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Sign up</title>
    <link rel="stylesheet" type="text/css" href="./css/jquery-ui-1.10.3.custom.min.css">
    <script type="text/javascript" src="./js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/jquery-ui-1.10.3.custom.min.js"></script>
    <script type="text/javascript" src="./js/scripts.js"></script>
</head>
<body>
<h2>Sign up:</h2>
<c:set var="ok" scope="session" value="${true}"/>
<c:if test="${!ok}">
    <p style="color: red">Email has already exists<p>
</c:if>
<form action="signup" method="post">
    <p>Your name:</p>
    <input type="text" name="name" >
    <p>Your lastname:</p>
    <input type="text" name="lastname">
    <p>День рождения</p>
    <input type="text" id="datepicker" name="birthday" />
    <p>Group</p>
    <input type="text" name="group">
    <p>Laboratory</p>
    <input type="text" name="laboratory">
    <p>Activity</p>
    <input type="text" name="activity">
    <p>Email</p>
    <input type="text" name="email">
    <br>
    <p>Password</p>
    <input type="password" name="pass">
    <br/>
    <button type="submit">Sign up!</button>
</form>
<a href="index.jsp">Already have account? Sign in now!</a>

</body>
</html>