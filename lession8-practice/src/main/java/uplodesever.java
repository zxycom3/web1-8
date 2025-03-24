/*
@author 
@Date   2025/3/24 16:58
@description
*/

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
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

@WebServlet("/up")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class uplodesever extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "TempFolder";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html;charset=utf-8");
        String applicationPath=getServletContext().getRealPath("");
        String uploadFilePath=applicationPath+ File.separator+UPLOAD_DIRECTORY;
        File uploadDir=new File(uploadFilePath);
        if(!uploadDir.exists())
        {
           uploadDir.mkdirs();
        }
        try
        {
            Collection<Part> parts= req.getParts();
            String description=null;
            Part partt=null;
            for(Part part:parts)
            {
                if(part.getHeader("Content-Disposition").contains("filename="))
                {
                    partt = part;
                }
                else
                {
                    description=req.getParameter(part.getName());
                }
            }
            if(partt!=null&&partt.getSize()>0)
            {
                String file= extractFileName(partt);
                Path filePath = Paths.get(uploadFilePath + File.separator + file);
                try(InputStream filecontent=partt.getInputStream())
                {
                    Files.copy(filecontent, filePath);
                }

                    if (description != null) {
                        System.out.println("文件描述: " + description);
                    }
                    resp.getWriter().println("文件 " + file + " 已成功上传！");
            }
            else
            {
                resp.getWriter().println("请选择一个文件进行上传。");
            }
        }
        catch (Exception ex) {
            resp.getWriter().println("发生错误: " + ex.getMessage());
        }
    }
    private String extractFileName(Part part)
    {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items)
        {
            if (s.trim().startsWith("filename"))
            {
                return s.substring(s.indexOf('=') + 2, s.length() - 1);
            }
        }
        return "";
    }
}
