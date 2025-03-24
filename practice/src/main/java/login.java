import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
@author 
@Date   2025/3/23 10:14
@description
*/
@WebServlet("/Login")
public class login extends HttpServlet
{
 //   private  static final String username="root";
 //  private  static final String password="123";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if("root".equals(username) && "123".equals(password))
        {
          //  resp.sendRedirect("/student.jsp");
         //   req.setAttribute();
            req.getRequestDispatcher("/stu").forward(req, resp);
         //   resp.sendRedirect(req.getContextPath() + "/student.jsp");
        }
        else
        {
            req.setAttribute("msg","账号或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
