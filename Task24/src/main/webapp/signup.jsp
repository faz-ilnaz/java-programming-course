<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Регистрация</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signup.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom.min.css">
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>
<div class="container">

    <c:set var="ok" scope="session" value="${true}"/>
    <c:if test="${!ok}">
        <div class="alert alert-danger">Данный email уже зарегистрирован в системе</div>
    </c:if>

    <form class="form-horizontal" id="signup_form" action="signup" method="post">
        <h2 class="form-horizontal-heading">Регистрация:</h2>

        <div class="form-group">
            <label for="name" class="col-sm-3 control-label">Имя</label>
            <div class="col-sm-8">
                <input class="form-control" id="name" type="text" name="name" placeholder="Имя">
            </div>
        </div>

        <div class="form-group">
            <label for="lastname" class="col-sm-3 control-label">Фамилия</label>
            <div class="col-sm-8">
                <input class="form-control" id="lastname" type="text" name="lastname" placeholder="Фамилия">
            </div>
        </div>

        <div class="form-group">
            <label for="datepicker" class="col-sm-3 control-label">Дата рождения</label>
            <div class="col-sm-8">
                <input class="form-control" id="datepicker" type="text" name="birthday">
            </div>
        </div>

        <div class="form-group">
            <label for="group" class="col-sm-3 control-label">Группа</label>
            <div class="col-sm-8">
                <input class="form-control" id="group" type="text" name="group" placeholder="Группа">
            </div>
        </div>

        <div class="form-group">
            <label for="laboratory" class="col-sm-3 control-label">Лаборатория</label>
            <div class="col-sm-8">
                <select class="form-control" id="laboratory" name="laboratory">
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
            </div>
        </div>


        <div class="form-group">
            <label for="activity" class="col-sm-3 control-label">Активности</label>
            <div class="col-sm-8">
                <input class="form-control" id="activity" type="text" name="activity" placeholder="Активности">
            </div>
        </div>


        <div class="form-group">
            <label for="email" class="col-sm-3 control-label">Email</label>
            <div class="col-sm-8">
                <input class="form-control" id="email" type="email" name="email" placeholder="Email">
            </div>
        </div>


        <div class="form-group">
            <label for="password" class="col-sm-3 control-label">Придумайте пароль</label>
            <div class="col-sm-8">
                <input class="form-control" id="password" type="password" name="password" placeholder="Пароль">
            </div>
        </div>

        <div class="form-group">
            <label for="confirm_password" class="col-sm-3 control-label">Повторите пароль</label>
            <div class="col-sm-8">
                <input class="form-control" id="confirm_password" type="password" name="confirm_password" placeholder="Повторите пароль">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-8">
                <button type="submit" class="btn btn-lg btn-primary btn-block">Зарегистрироваться!</button>
            </div>
        </div>

        <a href="index.jsp">У Вас уже есть аккаунт? Выполните вход!</a>
    </form>

</div>


</body>
</html>