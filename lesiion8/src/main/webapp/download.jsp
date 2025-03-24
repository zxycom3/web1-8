<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>文件下载</title>
</head>
<body>
<h2>文件下载列表</h2>

<ul>
    <%
        // 获取上传目录路径
        String applicationPath = application.getRealPath("");
        String uploadFilePath = applicationPath + File.separator + "TempFolder";

        // 创建目录（如果不存在）
        File uploadDir = new File(uploadFilePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // 获取目录中的所有文件
        File[] files = uploadDir.listFiles();
        List<String> fileList = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileList.add(file.getName());
                }
            }
        }

        // 显示文件列表并提供下载链接
        for (String fileName : fileList) {
    %>
    <li><a href="download?filename=<%= fileName %>"><%= fileName %></a></li>
    <%
        }
    %>
</ul>

<a href="upload.jsp">返回上传页面</a>
</body>
</html>