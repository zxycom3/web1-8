package booklib;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    // 模拟商品数据库
    private static final Map<String, Book> products = new HashMap<>();

    static {
        products.put("1001", new Book("1001", "Java Web基础", 56.00));
        products.put("1002", new Book("1002", "Spring Boot实战", 68.00));
        products.put("1003", new Book("1003","JAVA大全",88.00));
    }

    /*
     * 展示商品列表
     * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 用于存放所有商品
        List<Book> books = new ArrayList<>();
        // 遍历map取出所有商品存入List
        for (Map.Entry<String, Book> entry : products.entrySet()) {
            books.add(entry.getValue());
        }

        req.setAttribute("books", books);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    /*
     * 添加商品到购物车逻辑
     * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        List<Book> cart = (List<Book>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        if ("add".equals(action)) {
            String bookId = req.getParameter("id");
            if (bookId == null) {
                resp.sendRedirect(req.getContextPath()+"/books");
            }
            cart.add(products.get(bookId));
            session.setAttribute("cart", cart);

            resp.sendRedirect(req.getContextPath()+"/books");
        }
    }
}
