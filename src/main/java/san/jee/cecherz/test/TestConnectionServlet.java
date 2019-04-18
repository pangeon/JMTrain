package san.jee.cecherz.test;

import san.jee.cecherz.util.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "TestConnectionServlet", value = "/TestConnectionServlet")
public class TestConnectionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = "SELECT * FROM users;";
        try(Connection c = ConnectionProvider.connect();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(q))
        {
            PrintWriter p = resp.getWriter();
            while (rs.next()) {
                p.print(rs.getString("name"));
                p.println(" ");
                p.print(rs.getString("email"));
                p.println();
                System.out.print(rs.getString("name"));
                System.out.println("");
                System.out.print(rs.getString("email"));
                System.out.println("");
            }
        } catch (SQLException e) {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            e.printStackTrace();
        }
    }
}
