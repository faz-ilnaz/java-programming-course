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
            <%

                if (session != null
                        && session.getAttribute("student") != null) {
                    %>
                    <li><a href="signin">Home</a></li>
                    <li class="active"><a href="#">Users</a></li>
                    <li><a href="signout">Exit</a></li>
                    <%
                } else { %>
                    <li><a href="users">Back</a></li>
                    <li><a href="signin">Sign in</a></li>
                    <%
                }
            %>

        </ul>
        <h3 class="text-muted">Studentbook ITIS</h3>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-2">
            <img src="<c:out value='${a_student.ava_url}'/>" >
            <c:if test="${a_student.contacts != null}">
                <ul class="contacts">
                    <c:if test="${!a_student.contacts.gmail.isEmpty()}">
                        <li><a href="mailto:${a_student.contacts.gmail}">${a_student.contacts.gmail}</a></li>
                    </c:if>

                    <c:if test="${!a_student.contacts.vk.isEmpty()}">
                        <li><a href="${a_student.contacts.vk}">${a_student.contacts.vk}</a></li>
                    </c:if>

                    <c:if test="${!a_student.contacts.twitter.isEmpty()}">
                        <li><a href="${a_student.contacts.twitter}">${a_student.contacts.twitter}</a></li>
                    </c:if>

                    <c:if test="${!a_student.contacts.instagramm.isEmpty()}">
                        <li><a href="${a_student.contacts.instagramm}">${a_student.contacts.instagramm}</a></li>
                    </c:if>

                    <c:if test="${!a_student.contacts.linkedin.isEmpty()}">
                        <li><a href="${a_student.contacts.linkedin}">${a_student.contacts.linkedin}</a></li>
                    </c:if>
                </ul>
            </c:if>
        </div>

        <div class="col-md-5">

            <h2 class="user_name"><c:out value="${a_student.lastname} ${a_student.name}"/></h2>
            <p>
                Дата рождения: <c:out value="${a_student.birthday}"/><br>
                Группа: <c:out value="${a_student.group}"/><br>
                Лаборатория: <c:out value="${a_student.laboratory}"/><br>
                Активности: <c:out value="${a_student.activity}"/><br>
            </p>
            <c:if test="${a_student.information != null}">
                <p>Дополнительная информация:</p>
                <p><c:out value="${a_student.information}"/></p>
            </c:if>

        </div>
    </div>
</div>
</body>
</html>