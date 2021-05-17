
<%
    String message = pageContext.getException().getMessage();
    String exception = pageContext.getException().getClass().toString();
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
</head>
<body>

<h2>Exception occurred while processing the request</h2>
<p>Type: <%= exception%></p>
<p>Message: <%= message %></p>

</body>
</html>