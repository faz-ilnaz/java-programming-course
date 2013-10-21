<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Регистрация</title>
    <link rel="stylesheet" type="text/css" href="./css/jquery-ui-1.10.3.custom.min.css">
    <script type="text/javascript" src="./js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/jquery-ui-1.10.3.custom.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="./js/scripts.js"></script>
</head>
<body>
<h2>Регистрация:</h2>
<c:set var="ok" scope="session" value="${true}"/>
<c:if test="${!ok}">
    <p style="color: red">Данный email уже зарегистрирован в системе<p>
</c:if>
<form id="signup_form" action="signup" method="post">
    <p>
        <label for="name">Имя</label>
        <input id="name" type="text" name="name" >
    </p>
    <p>
        <label for="lastname">Фамилия</label>
        <input id="lastname" type="text" name="lastname">
    </p>
    <p>
        <label for="datepicker">Дата рождения</label>
        <input type="text" id="datepicker" name="birthday" />
    </p>
    <p>
        <label for="group">Группа</label>
        <input id="group" type="text" name="group">
    </p>
    <p>
        <label for="laboratory">Лаборатория</label>
        <select id="laboratory" name="laboratory">
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
    <p>
        <label for="activity">Активности</label>
        <input id="activity" type="text" name="activity">
    </p>
    <p>
        <label for="email">Email</label>
        <input id="email" type="text" name="email">
    </p>
    <p>
        <label for="password">Придумайте пароль</label>
        <input id="password" type="password" name="password">
    </p>
    <p>
        <label for="confirm_password">Повторите пароль</label>
        <input id="confirm_password" type="password" name="confirm_password">
    </p>
    <p>
        <button type="submit">Зарегистрироваться!</button>
    </p>
</form>
<a href="index.jsp">У Вас уже есть аккаунт? Выполните вход!</a>

</body>
</html>