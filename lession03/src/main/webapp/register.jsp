<%--
  Created by IntelliJ IDEA.
  User: ZhuanZ
  Date: 2025/3/15
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>

<br action= "register" method="post">
    用户名：</br><input type="text"  name="username"></br>
    密码：</br><input type="password" name="password"></br>
    验证码：<img src="register"></br>
    <img src="register" style="width: 50px;height: 30px" onclick="this.src='register?' + new Date().getTime()">
    <input type="text" name="vcode"></br>
    <input type="submit" value="注册">


</form>

</body>
</html>
