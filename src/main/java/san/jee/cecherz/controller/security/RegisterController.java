package san.jee.cecherz.controller.security;

import san.jee.cecherz.dao.exception.UnknownRoleException;
import san.jee.cecherz.model.Role;
import san.jee.cecherz.service.ProfileService;
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
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String ip = req.getRemoteAddr();
        ProfileService ps = new ProfileService();
        String token = new TokenProvider().getToken();
        try {
            ps.addProfile(email, password, Role.attendee, ip, token);
            System.out.println("Dodano użytkownika do bazy");
        } catch (UnknownRoleException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/start.jsp");

    }
}
