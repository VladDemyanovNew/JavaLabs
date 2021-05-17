
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <style><%@include file="/WEB-INF/css/register.css"%></style>
</head>
<body>

<div class="wrapper">
    <div class="form-section">
        <div class="form">
            <h1>Регистрация</h1>
            <form method="post" action="<c:url value='/register'/>" class="login-form">
                <input type="text" required placeholder="login" name="login" class="input-style">
                <input type="password" required placeholder="password" name="password" class="input-style">
                <div class="login-btn-section">
                    <input type="submit" value="Зарегестрироваться" class="login-btn">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>