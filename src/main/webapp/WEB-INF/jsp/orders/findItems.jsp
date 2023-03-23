<%@ page import="com.GuangGuangLi.entity.Items" %><%--
  Created by IntelliJ IDEA.
  User: liguang
  Date: 2023/3/23
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>findItems</title>
</head>

<body>
<c:forEach items="${itemsList }" var="item">
    <tr>
        <td>${item.name }</td>
        <td>${item.price }</td>
        <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td>${item.detail }</td>

    </tr>
</c:forEach>

</body>
</html>
