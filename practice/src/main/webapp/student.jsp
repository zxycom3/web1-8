<%--
  Created by IntelliJ IDEA.
  User: 张某人
  Date: 2025/3/23
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎</h1>
<table>
    <tr>
    <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.name}</td>>
            <td>${student.age}</td>>
            <td>${student.gender}</td>>
        </tr>>
    </c:forEach>>
</table>>
</body>
</html>
