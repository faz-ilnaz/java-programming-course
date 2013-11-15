<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<html>
<head>
    <title>Пользователи</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <link href="css/justified-nav.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <layout:header student="${student}"/>
    <%--TODO вместо скриплетов лучше использовать jstl теги, скриплеты очень подвержены уязвимостям.--%>
    <c:forEach items="${studentsList}" var="student">
        <a href="view?id=${student.id}"><img title="${student.lastname} ${student.name}" src="${student.ava_url}" /></a>
    </c:forEach>
</div>

</body>
</html>