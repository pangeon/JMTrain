package san.jee.cecherz.controller.security;

import org.springframework.dao.EmptyResultDataAccessException;
import san.jee.cecherz.service.ProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ActivateAccount", value = "/ActivateAccount")
public class ActivateAccount extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String email = req.getParameter("key1");
        String token = req.getParameter("key2");

        System.out.println(email);
        System.out.println(token);
        activateProfile(email, token, req, resp);

        req.setAttribute("email", email);
        req.getRequestDispatcher("/WEB-INF/info_reg.jsp?key1=" + email).forward(req, resp);
    }
    private void activateProfile(String email, String token, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ProfileService service = new ProfileService();
            service.updateProfileStatus(email, token);
        } catch(EmptyResultDataAccessException e) {
            req.getRequestDispatcher("/WEB-INF/info_expired.jsp").forward(req, resp);
            System.out.println("-- ActivateAccount | activateProfile() > EmptyResultDataAccessException--");
        }
    }
}
