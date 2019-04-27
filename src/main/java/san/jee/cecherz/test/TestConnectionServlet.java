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
            p.println("<html>");
                p.println("<head>");
                    p.println("<title>Profile</title>");
                    p.println("<meta charset=\"UTF-8\" \\>");
                    p.println("<link rel=\"stylesheet\" href=\"resources/css/main.css\">");
                p.println("</head>");
                p.println("<body>");
                    p.println("<h1>Profile użytkowników</h1>");
                    p.println("<table>");
                    while (rs.next()) {
                        p.println("<tr>");
                            p.println("<td>id: " + rs.getInt("id") + "</td>");
                            p.println("<td>email: " + rs.getString("email") + "</td>");
                            p.println("<td>password: " + rs.getString("password") + "</td>");
                            p.println("<td>ip: " + rs.getInt("ip") + "</td>");
                            p.println("<td>token: " + rs.getString("token") + "</td>");
                            p.println("<td>regstamp: " + rs.getTimestamp("regstamp") + "</td>");
                            p.println("<td>confstamp: " + rs.getTimestamp("confstamp") + "</td>");
                            p.println("<td>role: " + rs.getString("role") + "</td>");
                        p.println("</tr>");
                    }
                    p.println("</table>");
                p.println("</body>");
            p.println("</html>");
        } catch (SQLException e) {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            e.printStackTrace();
        }
    }
}
