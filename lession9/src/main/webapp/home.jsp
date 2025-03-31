<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/3/25
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

${msg}
<form action="products" method="post">
    商品名称：<input type="text" name="pname" required><br>

    商品简介：<input type="text" name="pdesc" required><br>

    商品价格：<input type="text" name="pprice" required><br>
    products
    <input type="submit" value="保存"><br>
</form>


<table>
    <tr>
        <th>商品ID</th>
        <th>商品名称</th>
        <th>商品简介</th>
        <th>商品价格</th>
    </tr>
    <c:forEach items="${products}" var="pro">
        <tr>
            <td>${pro.id}</td>
            <td>${pro.name}</td>
            <td>${pro.description}</td>
            <td>${pro.price}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
