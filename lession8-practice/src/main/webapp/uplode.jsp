<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>文件上传与下载</h2>

<%--指定表单数据的enctype属性以及提交方式--%>
<form action="up" enctype="multipart/form-data" method="post">
    <%--指定标记的类型和文件域的名称--%>
    文件描述：<input type="text" name="description"><br><br>
    选择上传文件：<input type="file" name="myfile"/><br/>
    <input type="submit" value="上传">
</form>
<a href="download.jsp">查看可下载文件列表</a>
</body>
</html>