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
                "jdbc:mysql://localhost:3306/JMTrainDB?useSSL=false&serverTimezone=UTC",
                "root",
                "Pangeon66#");
        Statement s = c.createStatement();
        String q = "SELECT * FROM Profiles;";
        ResultSet rs = s.executeQuery(q);

        Integer id = null;
        String email = null;
        String password = null;
        String role = null;
        while (rs.next()) {
            id = rs.getInt("id");
            email = rs.getString("email");
            password = rs.getString("password");
            role = rs.getString("role");
            System.out.println(
                            "id: " + id +
                            " | email: " + email +
                            " | pass: " + password +
                            " | role: " + role);
        }
        if(s != null) s.close();
        if(rs != null) rs.close();
        if(c != null) c.close();
    }
}
