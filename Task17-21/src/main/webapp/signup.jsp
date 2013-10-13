<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>sign up</title>
</head>
<body>
<h2>Sign up:</h2>

<form action="signup" method="post">
    <p>Your name:</p>
    <input type="text" name="name">
    <p>Email</p>
    <input type="text" name="email">
    <br>
    <p>Password</p>
    <input type="password" name="pass">
    <button type="submit">Sign up!</button>
</form>


</body>
</html>