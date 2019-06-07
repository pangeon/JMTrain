package san.jee.cecherz.controller.content;

import san.jee.cecherz.service.ProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StartController", value = "/start")
public class StartController extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/start.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getUserPrincipal() != null) {
            deleteProfile(req);
            req.getSession().invalidate();
            req.getRequestDispatcher("/WEB-INF/info.jsp").forward(req, resp);
            System.out.println("doPost | --StartController--");
        } else {
            resp.sendError(403);
        }
    }
    private void deleteProfile(HttpServletRequest req) {
        ProfileService service = new ProfileService();
        String email = req.getUserPrincipal().getName();
        service.deleteProfile(email);
        System.out.println("--deleteProfile--");
        System.out.println("email: " + email);
    }
}
