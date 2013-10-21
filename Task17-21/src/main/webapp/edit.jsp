<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
	<title>Профиль</title>
	<!-- Bootstrap core CSS -->
	<link href="css/bootstrap.css" rel="stylesheet">

	<link href="css/justified-nav.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom.min.css">

	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>
	<div class="container">
		<!-- Static navbar -->
		<div class="header">
	        <ul class="nav nav-pills pull-right">
	          <li><a href="index.jsp">Home</a></li>
	          <li class="active"><a href="#">Edit</a></li>
                <li><a href="index.jsp">Exit</a></li>
	        </ul>
        	<h3 class="text-muted">Studentbook ITIS</h3>
      	</div>
		<div id="tabs">
		  <ul>
		    <li><a href="#tabs-1">Личные данные</a></li>
		    <li><a href="#tabs-2">Контакты</a></li>
		  </ul>

            <%--<c:set var="student" scope="session" value="${null}"/>--%>
		  <div id="tabs-1">
		    <form id="edit_form1" action="edit" method="post">

                <label for="name">Имя</label>
			    <p><input id="name" type="text" name="name" value="<c:out value="${student.name}" />"></p>

                <label for="lastname">Фамилия</label>
			    <p><input id="lastname" type="text" name="lastname" value="<c:out value="${student.lastname}"/>"></p>

                <label for="datepicker">Дата рождения</label>
			    <p><input type="text" id="datepicker" name="birthday" value="<c:out value="${student.birthday}"/>"/></p>

                <label for="group">Группа</label>
			    <p><input id="group" type="text" name="group" value="<c:out value="${student.group}"/>"></p>

                <label for="laboratory">Лаборатория</label>
			    <p>
			    	<select id="laboratory" name="labs">
				    	<option value="0">Fujitsu Java</option>
				    	<option value="1">Fujitsu Retail</option>
				    	<option value="2">Fujitsu WATS</option>
				    	<option value="3">Fujitsu Testing</option>
				    	<option value="4">Fujitsu Infrastucture</option>
				    	<option value="5">Wextor</option>
				    	<option value="6">КИР</option>
				    	<option value="7">Интеллектуальные поисковые технологии и семантические технологии</option>
				    	<option value="8">Flatsoft</option>
				    	<option value="9">Барс Груп Python</option>
				    	<option value="10">Барс Груп JavaScript</option>
				    	<option value="11">Барс Груп .Net</option>
				    	<option value="12">SmartHead</option>
				    	<option value="13">Android (Samsung Android Labs)</option>
				    	<option value="14">JetBrains</option>
				    	<option value="15">FossLabs</option>
				    	<option value="16">Финлаб (Татфондбанк)</option>
                        <option value="17">Системы электронного документооборота</option>
				    	<option value="18">IOS</option>
				    </select>
				   </p>

                <label for="activity">Активности</label>
                <p><input id="activity" type="text" name="activity" value="<c:out value="${student.activity}"/>"></p>

			    <p>Дополнительная информация:</p>
			    <p>
                    <textarea name="information" rows="3" cols="30">
                        <c:out value="${student.information}"/>
				    </textarea>
                </p>

			    <p><input type="submit" value="Сохранить" class="sub"></p>

			</form>
		  </div>
		  <div id="tabs-2">
		    <form id="edit_form2" action="edit" method="post">

		    	<label for="gmail">Gmail</label>
		    	<p><input type="text" name="gmail" value="${student.contacts.gmail}"></p>

		    	<label for="vk">Вконтакте</label>
		    	<p><input type="text" name="vk" value="${student.contacts.vk}"></p>

		    	<label for="twitter">Twitter</label>
		    	<p><input type="text" name="twitter" value="${student.contacts.twitter}"></p>

		    	<label for="instagram">Instagram</label>
		    	<p><input type="text" name="instagram" value="${student.contacts.instagramm}"></p>

                <label for="linkedin">LinkedIn</label>
                <p><input type="text" name="linkedin" value="${student.contacts.linkedin}"></p>

		    	<p><input type="submit" value="Сохранить" class="sub"></p>
		    </form>
		  </div>
		</div>
	</div>
</body>
</html>