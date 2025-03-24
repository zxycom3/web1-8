<%--
  Created by IntelliJ IDEA.
  User: ZhuanZ
  Date: 2025/3/15
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="Login" method="post">

    用户名：<input type="text" name="username"></br>
    密 码：<input type="password" name="password"></br>
    <input type="submit" value="登录">

    <%=request.getAttribute("msg")%>

</form>


</body>
</html>
