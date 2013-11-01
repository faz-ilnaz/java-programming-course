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
            <li><a href="edit.jsp">Edit</a></li>
            <li><a href="index.jsp">Exit</a></li>
        </ul>
        <h3 class="text-muted">Studentbook ITIS</h3>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-2">
            <img src="images/default_avatar.gif" >
            <ul class="contacts">
                <li><a href="mailto:${student.contacts.gmail}">${student.contacts.gmail}</a></li>
                <li><a href="${student.contacts.vk}">${student.contacts.vk}</a></li>
                <li><a href="${student.contacts.twitter}">${student.contacts.twitter}</a></li>
                <li><a href="${student.contacts.instagramm}">${student.contacts.instagramm}</a></li>
                <li><a href="${student.contacts.linkedin}">${student.contacts.linkedin}</a></li>
            </ul>
        </div>

        <div class="col-md-5">

            <h2 class="user_name"><c:out value="${student.lastname} ${student.name}"/></h2>
            <p>
                Дата рождения: <c:out value="${student.birthday}"/><br>
                Группа: <c:out value="${student.group}"/><br>
                Лаборатория: <c:out value="${student.laboratory}"/><br>
                Активности: <c:out value="${student.activity}"/><br>
            </p>
            <c:if test="${student.information != null}">
                <p>Дополнительная информация:</p>
                <p><c:out value="${student.information}"/></p>
            </c:if>

        </div>
    </div>
</div>
</body>
</html>