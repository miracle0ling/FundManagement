<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>序号</td>
        <td>货物或应税劳务、服务名称</td>
        <td>单位</td>
        <td>数量</td>
        <td>单价（税后）</td>
        <td>金额</td>
        <td>税额</td>
    </tr>
    <c:forEach items="${library}" var="l">
        <tr>
            <td>${l.lid}</td>
            <td>${l.tname}</td>
            <td>${l.dw}</td>
            <td>${l.quantity}</td>
            <td>${l.unitprice}</td>
            <td>${l.money}</td>
            <td>${l.tax}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">总价</td>
        <td colspan="4">${count}</td>
    </tr>
</table>
</body>
</html>
