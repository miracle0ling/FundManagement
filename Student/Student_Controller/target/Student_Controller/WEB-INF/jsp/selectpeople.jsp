<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>人員</td>
        <td>交通方式</td>
        <td>票價</td>
    </tr>
    <c:forEach items="${peopleList}" var="l">
        <tr>
            <td>${l.pname}</td>
            <td>${l.transport}</td>
            <td>${l.price}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="2">总价</td>
        <td>${count}</td>
    </tr>
</table>
</body>
</html>
