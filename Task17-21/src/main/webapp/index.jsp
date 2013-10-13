<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h2>Sign in:</h2>
<c:set var="ok" scope="session" value="${true}"/>
<c:if test="${!ok}">
<p style="color: red">Error<p>
    </c:if>
<form action="hello" method="post">
    <p>Email</p>
    <input type="text" name="email">
    <br>
    <p>Password</p>
    <input type="password" name="pass">
    <button type="submit">OK</button>
</form>

<a href="signup.jsp">Sign up now!</a>


</body>
</html>