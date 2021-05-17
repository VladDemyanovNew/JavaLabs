
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>USER</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style><%@include file="/WEB-INF/css/user.css"%></style>
</head>
<body>
    <header id="header" class="header">
        <a href="<c:url value="/logout"/>" class="logout-style">Logout</a>
        <div class="user-info">
            <p>User <b>${person.getLogin()}</b></p>
            <i class="fas fa-user"></i>
        </div>
    </header>

    <section id="main-section" class="main-section">
        <div class="dragons-view">
            <c:forEach var="dragon" items="${dragons}">
                <ul>
                    <li>Имя: <c:out value="${dragon.getName()}"/></li>
                    <li>Здоровье: <c:out value="${dragon.getHealth()}"/></li>
                    <li>Сила: <c:out value="${dragon.getPower()}"/></li>
                    <form method="post" action="<c:url value='/delete_dragon'/>">
                        <input type="number" hidden name="id" value="${dragon.getId()}" />
                        <input type="submit" name="delete" value="Удалить" class="btn-style-second"/>
                    </form>
                </ul>
                <hr/>
            </c:forEach>
        </div>
        <div class="dragon-constructor">
            <h2>Создайте нового дракона</h2>
            <form method="post" action="<c:url value='/add_dragon'/>">
                <input type="text" required placeholder="Название" name="name">
                <input type="text" required placeholder="Сила" name="power">
                <input type="text" required placeholder="Здоровье" name="health">
                <input type="submit" value="Создать" class="btn-style">
            </form>
        </div>
    </section>

</body>
</html>
