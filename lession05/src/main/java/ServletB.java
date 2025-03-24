import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author ZhuanZ
 * @Date 2025/3/20 11:18
 * @Description:
 */
@WebServlet("/b")
public class ServletB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException{
        Cookie[] cookies=req.getCookies();
        for (Cookie cookie : cookies){
            String cname=cookie.getName();
            String cvalue=cookie.getValue();
            System.out.println("name:\t" + "\tvalue\t" +cvalue);
        }
    }
}
