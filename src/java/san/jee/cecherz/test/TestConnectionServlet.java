package san.jee.cecherz.test;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "Test", value = "/Test")
public class TestConnectionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    @Named("java:comp/env/jdbc/jee_db")
    private DataSource ds;

    public TestConnectionServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = "SELECT * FROM users;";
        try(Connection c = ds.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(q))
        {
            PrintWriter p = resp.getWriter();
            while (rs.next()) {
                p.println(rs.getString("email"));
                p.println("::");
                p.println(rs.getString("name"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            //req.getRequestDispatcher("error.jsp").forward(req, resp);
            e.printStackTrace();
        }
    }
}
