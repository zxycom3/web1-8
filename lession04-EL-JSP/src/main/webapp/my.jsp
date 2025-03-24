<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
使用JSP表达式：</br>

用户名：<%=request.getAttribute("username")%>
密  码：<%=request.getAttribute("password")%>

使用EL表达式：</br>
用户名：${username}
密  码：${password}

</br>

stu对象：
ID：${s.id}
学号：${s.num}
姓名：${s.name}
</br>


empty 判空</br>
a是否为空：${empty a}  </br>
b是否为空：${empty b}







</body>
</html>
