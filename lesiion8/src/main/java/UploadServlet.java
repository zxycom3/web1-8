import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)    // 50MB
public class UploadServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "TempFolder";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        // 获取保存上传文件的目录路径
        String applicationPath = getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIRECTORY;

        // 创建目录（如果不存在）
        File uploadDir = new File(uploadFilePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // 从请求中获取所有部分
            Collection<Part> parts = request.getParts();

            String description = null;
            Part filePart = null;

            for (Part part : parts)
            {
                // 检查是否为文件部分
                if (part.getHeader("Content-Disposition").contains("filename="))
                {
                    filePart = part;
                }
                else
                {
                    // 假设只有一个非文件部分是描述
                    description = request.getParameter(part.getName());
                }
            }

            if (filePart != null && filePart.getSize() > 0)
            {
                // 从头部字段提取文件名
                String fileName = extractFileName(filePart);
                // 将文件保存到服务器
                Path filePath = Paths.get(uploadFilePath + File.separator + fileName);
                try (InputStream fileContent = filePart.getInputStream())
                {
                    Files.copy(fileContent, filePath);
                }
                // 处理文件描述
                if (description != null) {
                    System.out.println("文件描述: " + description);
                }

                // 向客户端发送成功消息
                response.getWriter().println("文件 " + fileName + " 已成功上传！");
            }
            else
            {
                response.getWriter().println("请选择一个文件进行上传。");
            }
        } catch (Exception ex) {
            response.getWriter().println("发生错误: " + ex.getMessage());
        }
    }

    /**
     * 从Part头部内容解析出文件名
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf('=') + 2, s.length() - 1);
            }
        }
        return "";
    }
}