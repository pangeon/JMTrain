package san.jee.cecherz.controller.content;

import san.jee.cecherz.model.Profiles;
import san.jee.cecherz.service.ProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "ProfilesController", value = "/profile")
public class ProfilesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getUserPrincipal() != null) {
            saveProfilesInRequest(req);
            req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, resp);
        } else {
            resp.sendError(403);
        }
    }

    private void saveProfilesInRequest(HttpServletRequest req) {
        ProfileService service = new ProfileService();
        List<Profiles> profilesList = service.getAllProfiles(Comparator.comparing(Profiles::getId));
        req.setAttribute("profilesList", profilesList);
        System.out.println("--saveProfilesInRequest--");
        for (Profiles profile : profilesList) {
            System.out.println(profile);
        }
    }
}
