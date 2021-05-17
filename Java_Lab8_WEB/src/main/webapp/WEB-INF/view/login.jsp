
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style><%@include file="/WEB-INF/css/login.css"%></style>
</head>
<body>

<div class="wrapper">
    <div class="form-section">
        <div class="form">
            <h1>Вход в систему</h1>
            <form method="post" action="" class="login-form">
                <input type="text" required placeholder="login" name="login" class="input-style">
                <input type="password" required placeholder="password" name="password" class="input-style">
                <div class="login-btn-section">
                    <input type="submit" value="Войти" class="login-btn">
                </div>
            </form>
            <form method="get" action="<c:url value='/register'/>" class="register-form">
                <input type="submit" name="register" value="Зарегестрироваться" class="register-btn"/>
            </form>
        </div>
    </div>
</div>


</body>
</html>