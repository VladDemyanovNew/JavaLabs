<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="letscodeTags" prefix="lct" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1><%= "Hello World!" %></h1>
    <br/>
    <a href="hello-servlet">Hello Servlet</a>
    <br/>
    <lct:emptyTag />
    <br/>
    <lct:paramsTag a="10" b="100">
        <%= 100 * 3 %>
    </lct:paramsTag>
    <br/>
    <lct:textBodyTag iterations="3">
        <tr>
            <td>some text</td>
            <td><lct:emptyTag/></td>
            <td><%= 100 %></td>
        </tr>
    </lct:textBodyTag>

    <lct:expressionBodyTag>
        test1 - text test1 - test2 - text test2
    </lct:expressionBodyTag>
</body>
</html>