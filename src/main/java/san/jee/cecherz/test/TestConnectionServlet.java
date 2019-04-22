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
        String q = "SELECT * FROM Profiles;";
        try(Connection c = ConnectionProvider.connect();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(q))
        {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html");
            PrintWriter p = resp.getWriter();
            p.print("<html>");
                p.print("<head>");
                    p.print("<title>Profile</title>");
                    p.print("<meta charset=\"UTF-8\" \\>");
                    p.print("<link rel=\"stylesheet\" href=\"css/main.css\">");
                p.print("</head>");
                p.print("<body>");
                    p.print("<h1>Profile użytkowników</h1>");
                    p.print("<table>");
                    while (rs.next()) {
                        p.print("<tr>");
                            p.print("<td>id: " + rs.getInt("id") + "</td>");
                            p.print("<td>email: " + rs.getString("email") + "</td>");
                            p.print("<td>password: " + rs.getString("password") + "</td>");
                            p.print("<td>role: " + rs.getString("role") + "</td>");
                        p.print("</tr>");
                    }
                    p.print("</table>");
                p.print("</body>");
            p.print("</html>");
        } catch (SQLException e) {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            e.printStackTrace();
        }
    }
}
