<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: usts4
  Date: 2018/8/9
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Country</title>
</head>
<body>
<table>
    <tr>
        <th>序号</th>
        <th>名称</th>
    </tr>
    <c:forEach items="${countries}" var="item" varStatus="v">
        <tr>
            <td>${v.count}</td>
            <td>${item}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
