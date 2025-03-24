import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author ZhuanZ
 * @Date 2025/3/20 11:15
 * @Description:
 */
@WebServlet("/a")
public class ServletA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException{
        Cookie cookie=new Cookie("username","root");
        resp.addCookie(cookie);
    }
}
