<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
	<title>Search app</title>
	  <!-- Bootstrap core CSS -->
	  <link href="css/bootstrap.css" rel="stylesheet">

	  <!-- Custom styles for this template -->
	  <link href="css/signin.css" rel="stylesheet">
  </head>
  <body>
	   <div class="container">

           <form class="form-signin" action="find" method="post">
               <h2 class="form-signin-heading">Search app</h2>
               <input type="text" class="form-control" name="filename" placeholder="file name" autofocus>
               <input type="text" class="form-control" name="path" placeholder="path">
               <button class="btn btn-lg btn-primary btn-block" type="submit">Search!</button>

               <c:set var="exception" scope="session" value="${null}"/>
               <c:if test="${exception != null}">
                   <p class="text-danger text-center">
                       <c:out value="${exception}"/>
                   </p>
               </c:if>
               <c:set var="list" scope="session" value="${null}"/>
               <c:choose>

                   <c:when test="${list != null && !list.isEmpty()}">
                       <p class="text-success">Found <c:out value="${list.size()}"/> file(s):</p>
                       <c:forEach  items="${list}" var="current">
                           <p><c:out value="${current}"/><p>
                       </c:forEach>
                   </c:when>

                   <c:when test="${list != null && list.isEmpty()}">
                       <p class="text-warning">File not found</p>
                   </c:when>

                   <c:otherwise>
                       <p>Enter the file name and path to search in the form above</p>
                   </c:otherwise>
               </c:choose>
           </form>

	   </div>

  </body>
</html>