import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();

        List<Product> products = productDAO.findAll();

        // 将查询结果存储到request对象中
        request.setAttribute("products", products);

        // 转发请求到JSP页面
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        ProductDAO productDAO = new ProductDAO();
        String name = req.getParameter("pname");
        String desc = req.getParameter("pdesc");
        String price = req.getParameter("pprice");
        Product product = new Product();
        product.setName(name);
        product.setDescription(desc);
        product.setPrice(Double.parseDouble(price));
        boolean flag = productDAO.addProduct(product);
        String msg = null;
        if (flag)
        {
            //添加成功
            msg = "添加成功";
        }
        else
        {
            // 添加失败
            msg = "添加失败";
        }
        req.setAttribute("msg", msg);
        List<Product> products = productDAO.findAll();
        // 将查询结果存储到request对象中
        req.setAttribute("products", products);
        // 转发请求到JSP页面
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
