import java.sql.ResultSet;

public class UserDao {

    public User getUserByName(String name) {
        User user = null;
        String query = "SELECT * FROM user where username=?";
        try {
            ResultSet rs = JdbcUtil.executeQuery(query,name);
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return user;
    }
}