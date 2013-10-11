<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Adder</title>
  </head>
  <body>
       <form action="add" method="get">
           <h2>Adder</h2>
           <input type="text" name="num1" autofocus>
           +
           <input type="text" name="num2">
           <button type="submit"> = </button>
       </form>
       <c:set var="result" scope="session" value="${null}"/>
       <c:if test="${result != null}">
           <p><c:out value="${num1}"/>  +
               <c:out value="${num2}"/>  =
               <c:out value="${result}"/></p>
       </c:if>

  </body>
</html>