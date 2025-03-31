import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO
{
    public List<Product> findAll()
    {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM products";
        try
        {
            ResultSet rs = JdbcUtil.executeQuery(query);
            while (rs.next())
            {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                productList.add(product);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return productList;
    }

    public boolean addProduct(Product product)
    {
        String sql = "INSERT INTO products (name, description, price) VALUES (?, ?, ?)";
        int flag = JdbcUtil.executeUpdate(sql, product.getName(), product.getDescription(), product.getPrice());
        return flag > 0;
    }
}
