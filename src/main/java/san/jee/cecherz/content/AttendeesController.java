package san.jee.cecherz.content;

import san.jee.cecherz.model.Profiles;
import san.jee.cecherz.service.AttendeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AttendeesController", value = "/account")
public class AttendeesController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(req.getUserPrincipal() != null) {
            req.getRequestDispatcher("profile.jsp").forward(req, resp);
        } else {
            resp.sendError(403);
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String city = req.getParameter("city");
        String postcode = req.getParameter("postcode");
        String street = req.getParameter("street");
        Profiles activeProfile = (Profiles) req.getSession().getAttribute("user");

        if(req.getUserPrincipal() != null) {
            AttendeeService as = new AttendeeService();
            as.addProfileInfo(activeProfile, name, surname, phone, city, postcode, street);
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            resp.sendError(403);
        }

    }


}
