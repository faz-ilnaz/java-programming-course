<%@ tag pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="student" type="ru.kpfu.itis.servlets.model.Student" required="true" rtexprvalue="true"%>
<div class="header">
    <ul class="nav nav-pills pull-right">
        <c:choose>
            <c:when test="${not empty student}">
                <li><a href="signin">Home</a></li>
                <li class="active"><a href="#">Users</a></li>
                <li><a href="edit">Edit</a></li>
                <li><a href="signout">Exit</a></li>
            </c:when>
            <c:otherwise>
                <li class="active"><a href="#">Users</a></li>
                <li><a href="signin">Sign in</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
    <h3 class="text-muted">Studentbook ITIS</h3>
</div>