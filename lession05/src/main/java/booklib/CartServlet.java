package booklib;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    /*
     * 查看购物车
     * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        // 用于判断用户购物车是否有商品
        boolean flag = true;
        List<Book> cart = null;

        if (session==null){
            flag = false;
        }else {
            cart = (List<Book>) session.getAttribute("cart");
            if (cart==null){
                flag = false;
            }
        }

        if (flag){
            req.setAttribute("cart", cart);
            req.getRequestDispatcher("cart.jsp").forward(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath()+"/books");
        }


    }


}
