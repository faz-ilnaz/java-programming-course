<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sign up</title>
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
    <p>Email</p>
    <input type="text" name="email">
    <br>
    <p>Password</p>
    <input type="password" name="pass">
    <button type="submit">Sign up!</button>
</form>
<a href="index.jsp">Already have account? Sign in now!</a>

</body>
</html>