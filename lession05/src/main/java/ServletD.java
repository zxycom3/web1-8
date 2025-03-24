import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author ZhuanZ
 * @Date 2025/3/20 11:29
 * @Description:
 */
@WebServlet("/d")
public class ServletD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException{
        HttpSession session= req.getSession();
        System.out.println(session.getId());
        System.out.println(session.getAttribute("name"));
    }
}
