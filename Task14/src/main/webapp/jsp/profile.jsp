<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Профиль</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <link href="css/justified-nav.css" rel="stylesheet">

    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="index.jsp">Exit</a></li>
        </ul>
        <h3 class="text-muted">Studentbook ITIS</h3>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-2">
            <img src="images/default_avatar.gif" >
            <ul class="contacts">
                <li>+71231231231</li>
                <li><a href="mailto:ivanovivan@gmail.com">ivanovivan@gmail.com</a></li>
                <li><a href="http://vk.com/ivanov_ivan">vk.com/ivanov_ivan</a></li>
                <li><a href="http://twitter.com/ivanov_ivan">twitter.com/ivanov_ivan</a></li>
                <li><a href="http://instagram.com/ivanov_ivan">instagram.com/ivanov_ivan</a></li>
            </ul>
        </div>
        <div class="col-md-5">

            <h2 class="user_name">Иванов Иван</h2>
            <p>
                Дата рождения: 15 февраля 1994<br>
                Группа: 11-2106<br>
                Лаборатория: JetBrains Lab<br>
                Активности: спорторг<br>
                Дополнительная информация:
            </p>
            <ul>
                <li>Участник Студвесны 2012</li>
                <li>Призер олимпиады по программированию: 3 место</li>
                <li>Окончил художественную школу</li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>