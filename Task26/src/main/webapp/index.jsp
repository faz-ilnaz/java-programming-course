<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sign in</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/justified-nav.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li><a href="users">Users</a></li>
            <li class="active"><a href="#">Sign in</a></li>
        </ul>
        <h3 class="text-muted">Studentbook ITIS</h3>
    </div>

    <c:set var="ok" scope="session" value="${true}"/>
    <c:if test="${!ok}">
        <div class="alert alert-danger">Неверный логин или пароль</div>
    </c:if>
    <form class="form-signin" action="signin" method="post">
        <h2 class="form-signin-heading">Войти</h2>
        <input class="form-control" type="text" name="email" placeholder="Email" autofocus>
        <input class="form-control" type="password" name="pass" placeholder="Пароль">
        <button class="btn btn-lg btn-primary btn-block" type="submit">OK</button>
        <a href="signup.jsp">Зарегистрироваться!</a>
        <p></p>
        <p class="text-success"><b>ivanov@example.com(123456)</b></p>
        <p class="text-success"><b>vika@example.com(vika123)</b></p>
        <p class="text-success"><b>kostya@example.com(54321)</b></p>
    </form>

</div>

</body>
</html>