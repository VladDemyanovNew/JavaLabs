
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lab12</title>
</head>
<body>
    <!-- Tag set and if -->
    <c:set var="flag" value="true" scope="page"/>
    <c:if test="${ not empty flag and flag eq 'true' }">
        <p style="color: #ff5722">Hello JSTL</p>
    </c:if>

    <!-- Tag choose -->
    <c:set var="number" value="50"/>
    <c:choose>
        <c:when  test="${ number > 10 }" >
            <p>
                <c:out  value="число ${ number } больше 10"/>
            </p>
        </c:when>
        <c:when  test="${ number > 40 }" >
            <p>
                <c:out  value="число ${ number } больше 40"/>
            </p>
        </c:when>
        <c:when  test="${ number > 60 }" >
            <p>
                <c:out  value="число ${ number } больше 60"/>
            </p>
        </c:when>
        <c:otherwise>
            <p>
                <c:out  value="число ${ number } меньше 10"/>
            </p>
        </c:otherwise>
    </c:choose>

    <!-- Tag url -->
    <a href="<c:url value="/logout"/>"><c:url value="/logout"/></a>

    <!-- Tag redirect -->
    <c:set var="val" value="false"/>
    <c:if test="${val == true}">
        <c:redirect url="/WEB-INF/view/error.jsp" />
    </c:if>

    <br/>

    <!-- JSTL Formatting -->
    <jsp:useBean id="now" class="java.util.Date" />
    <fmt:setLocale value="en-EN"/>
    Вывод даты в формате English<br/>
    Сегодня: <fmt:formatDate value="${now}" /><br/>
    <fmt:setLocale value="ru-RU"/>
    Вывод даты в формате Russian<br/>
    Сегодня:  <fmt:formatDate value="${now}" /><br/>
    Стиль времени:
    (short):  <fmt:formatDate value="${now}" type="time" timeStyle="short" /><br/>
    (medium): <fmt:formatDate value="${now}" type="time" timeStyle="medium" /><br/>
    (long):   <fmt:formatDate value="${now}" type="time" timeStyle="long" /><br/>

    <br/>

    <c:set var="currentNumber" value="118000"/>
    <c:out value="Вывод формата числа : ${currentNumber}"/> <br/>
    Формат (по умолчанию) : <fmt:formatNumber value="${currentNumber}" /><br/>
    Процентный формат :   <fmt:formatNumber value="${currentNumber}" type="percent"/><br/>
    <fmt:setLocale value="be-BY"/>
    Белорусские рубли :     <fmt:formatNumber value="${currentNumber}" type="currency"/><br/>

    <!-- JSTL SQL -->
    <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
                       url="jdbc:mysql://localhost:3306/Lab9_database?serverTimezone=Europe/Moscow&useSSL=false&allowPublicKeyRetrieval=true"
                       user="root"  password="admin"/>

    <sql:query dataSource="${db}" var="rs">
        SELECT * from Person;
    </sql:query>

    <br/>
    <table border="1" width="400px">
        <tr>
            <th>Login</th>
            <th>Password</th>
        </tr>
        <c:forEach var="table" items="${rs.rows}">
            <tr>
                <td><c:out value="${table.login}"/></td>
                <td><c:out value="${table.password}"/></td>
            </tr>
        </c:forEach>
    </table>

    <!-- JSTL functions -->
    <c:set var="str" value="Hello world!"/>
    <p>value: ${str}</p>
    <p>length: ${fn:length(str)}</p>
    <p>toLowerCase: ${fn:toLowerCase(str)}</p>
    <p>toUpperCase: ${fn:toUpperCase(str)}</p>
    <p>substring: ${fn:substring(str, 2, 5)}</p>

</body>
</html>
