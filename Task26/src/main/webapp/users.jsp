<%@ page import="ru.kpfu.itis.servlets.model.Student" %>
<%@ page import="java.util.List" %>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Пользователи</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <link href="css/justified-nav.css" rel="stylesheet">
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
                    <li><a href="edit">Edit</a></li>
                    <li><a href="signout">Exit</a></li>
                    <%
                    } else { %>
                    <li class="active"><a href="#">Users</a></li>
                    <li><a href="signin">Sign in</a></li>
                    <%
                }
            %>
        </ul>
        <h3 class="text-muted">Studentbook ITIS</h3>
    </div>

    <%
        List<Student> students= (List) request.getAttribute("studentsList");

        if (students.size()>0) {
            for (Student student: students) {
                %>
                <a href="view?id=<%= student.getId() %>"><img title="<%=student.getLastname() + " " + student.getName()%>" src="<%=student.getAva_url()%>" /></a>
                <%
            }
        }
    %>

</div>

</body>
</html>