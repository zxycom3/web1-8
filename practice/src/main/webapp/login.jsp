
<%--
  Created by IntelliJ IDEA.
  User: 张某人
  Date: 2025/3/23
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>恭喜你猜对了！登陆吧！！！！！！</h2>
<span style="color: #0055ff">${msg}</span>
<form action="Login" method="post">
     账号： <input type="text" name="username">
     密码:  <input type="password" name="password">
    <input type="submit" value="登录">
</form>

</body>
</html>
