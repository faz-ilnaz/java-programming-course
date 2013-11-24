<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Feedback</title>
      <!-- Bootstrap core CSS -->
      <link href="css/bootstrap.css" rel="stylesheet">

      <!-- Custom styles for this template -->
      <link href="css/signin.css" rel="stylesheet">

      <script type="text/javascript" src="js/bootstrap.js"></script>
  </head>
  <body>
  <div class="container">

      <form class="form-signin" action="send" method="post" accept-charset="UTF-8">
          <h2 class="form-signin-heading">Feedback</h2>
          <input type="text" class="form-control" name="email" placeholder="Your e-mail..." autofocus>
          <textarea class="form-control" name="content" rows="3"></textarea>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Send</button>


      </form>

  </div>

  </body>
</html>