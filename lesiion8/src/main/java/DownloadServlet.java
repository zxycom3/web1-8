import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "TempFolder";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        // 获取上传目录路径
        String applicationPath = getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIRECTORY;

        // 获取请求参数中的文件名
        String fileName = request.getParameter("filename");

        if (fileName == null || fileName.isEmpty()) {
            // 如果没有文件名参数，则重定向到下载列表页面
            response.sendRedirect("download.jsp");
            return;
        }

        // 构建文件路径
        File file = new File(uploadFilePath + File.separator + fileName);

        if (!file.exists()) {
            response.getWriter().println("文件不存在。");
            return;
        }

        // 对文件名进行URL编码，以确保特殊字符能够正确处理
        String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());

        // 设置响应头以触发下载对话框
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");
        response.setContentLength((int) file.length());

        // 将文件写入响应输出流
        try (FileInputStream inStream = new FileInputStream(file);
             OutputStream outStream = response.getOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        }
    }
}