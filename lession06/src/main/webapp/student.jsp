<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>

<table>
    <tr>
        <th>ID</th>
        <th>学号</th>
        <th>姓名</th>
    </tr>
    <c:forEach items="${students}" var="st">
        <tr>
            <td>${st.id}</td>
            <td>${st.num}</td>
            <td>${st.name}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>