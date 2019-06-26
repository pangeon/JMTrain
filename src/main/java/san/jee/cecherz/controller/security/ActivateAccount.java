package san.jee.cecherz.controller.security;

import san.jee.cecherz.model.Profiles;
import san.jee.cecherz.service.ProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ActivateAccount", value = "/ActivateAccount")
public class ActivateAccount extends HttpServlet {

    /*
    ActivateAccount?key1=adam.czapka@gmail.com&key2=753f369
     */

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String email = req.getParameter("key1");
        String token = req.getParameter("key2");
        req.setAttribute("email", email);
        System.out.println(email);
        System.out.println(token);
        activateProfile(email, token);

        req.getRequestDispatcher("/WEB-INF/info_reg.jsp?key1=" + email).forward(req, resp);
    }
    private void activateProfile(String email, String token) {
        ProfileService service = new ProfileService();
        service.updateProfileStatus(email, token);
    }
}
