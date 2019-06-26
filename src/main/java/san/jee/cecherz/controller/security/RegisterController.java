package san.jee.cecherz.controller.security;

import org.springframework.dao.DuplicateKeyException;
import san.jee.cecherz.dao.exception.UnknownRoleException;
import san.jee.cecherz.model.Role;
import san.jee.cecherz.service.ProfileService;
import san.jee.cecherz.util.EmailSender;
import san.jee.cecherz.util.TokenProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String ip = req.getRemoteAddr();
        ProfileService ps = new ProfileService();
        String token = new TokenProvider().getToken();
        try {
            ps.addProfile(email, password, Role.attendee, ip, token);
            System.out.println("--RegisterController--");
            System.out.println("Add user to database");
        } catch (UnknownRoleException | DuplicateKeyException e) {
            System.out.println("--RegisterController--");
            System.out.println("Error in user role");
            e.printStackTrace();
        }
        System.out.println("--doPost | RegisterController--");
        System.out.println("email: " + email);
        System.out.println("password: " + password);
        System.out.println("ip(v4): " + ip);
        System.out.println("token: " + token);

        EmailSender sender = new EmailSender(email, token);
        sender.sendEmail();
        req.getRequestDispatcher("/WEB-INF/info.jsp").forward(req, resp);
    }
}
