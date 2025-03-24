<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 50px;
        }
        .login-container {
            width: 300px;
            margin: auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
        }
        .login-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #5fbae9;
            border: none;
            color: white;
            cursor: pointer;
        }
        .login-container input[type="submit"]:hover {
            background-color: #4a9ad4;
        }
        .login-container label {
            margin-left: 5px;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>登录</h2>
    <span style="color: red">${msg}</span>
    <form action="login" method="post">
        <label for="username">用户名:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">密码:</label>
        <input type="password" id="password" name="password" required>

        <label>
            <input type="checkbox" name="rememberMe" value="yes"> 记住我
        </label>

        <input type="submit" value="登录">
        <br>
        <a style="float: right" href="">没有账号？注册</a>
    </form>
</div>
</body>
</html>
