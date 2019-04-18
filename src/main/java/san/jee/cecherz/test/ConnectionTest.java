package san.jee.cecherz.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC",
                "root",
                "Pangeon66#");
        Statement s = c.createStatement();
        String q = "SELECT * FROM users;";
        ResultSet rs = s.executeQuery(q);

        String name = null;
        String email = null;
        while (rs.next()) {
            name = rs.getString("name");
            email = rs.getString("email");
            System.out.println(name + " " + email);
        }
        if(s != null) s.close();
        if(rs != null) rs.close();
        if(c != null) c.close();
    }
}
