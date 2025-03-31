import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil
{
    // 数据库连接参数
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javaweb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "211704595";
    // 初始化数据库连接
    public static Connection getConnection()
    {
        try
        {
            // 加载数据库驱动类
            Class.forName(JDBC_DRIVER);
            // 建立连接
            return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw new RuntimeException("获取数据库连接失败", e);
        }
    }

    // 关闭资源
    public static void closeResources(Connection conn, PreparedStatement pstmt, ResultSet rs)
    {
        try
        {
            if (rs != null)
            {
                rs.close();
            }
            if (pstmt != null)
            {
                pstmt.close();
            }
            if (conn != null)
            {
                conn.close();
            }
        }
        catch (SQLException e)
        {
            System.out.println("关闭失败");
            throw new RuntimeException( e);
        }
    }

    // 执行更新操作（INSERT, UPDATE, DELETE）
    public static int executeUpdate(String sql, Object... params)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try
        {
            // 获取数据库连接
            conn = getConnection();
            // 获取PreparedStatement对象(用于执行sql的对象),执行预编译的sql语句
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++)
            {
                // 设置参数
                pstmt.setObject(i + 1, params[i]);
            }
            // 执行sql
            return pstmt.executeUpdate();
        }
        catch (Exception e)
        {
            throw new RuntimeException("执行更新操作失败", e);
        }
        finally
        {
            // 关闭资源
            closeResources(conn, pstmt, null);
        }
    }
    // 查询操作
    public static ResultSet executeQuery(String sql, Object... params)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try
        {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++)
            {
                pstmt.setObject(i + 1, params[i]);
            }
            return pstmt.executeQuery();
        }
        catch (Exception e)
        {
            throw new RuntimeException("执行查询操作失败", e);
        }
    }
}
