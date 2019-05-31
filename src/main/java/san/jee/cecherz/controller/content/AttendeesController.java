package san.jee.cecherz.controller.content;

import san.jee.cecherz.model.Attendees;
import san.jee.cecherz.model.Profiles;
import san.jee.cecherz.service.AttendeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.List;

@WebServlet(name = "AttendeesController", value = "/account")
public class AttendeesController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(req.getUserPrincipal() != null) {
            saveAttendeesInRequest(req);
            Profiles profiles = (Profiles) req.getSession().getAttribute("user");
            BigInteger FK = profiles.getId();
            saveAttendeeInfoInRequest(req, FK);
            req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, resp);
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
    private void saveAttendeesInRequest(HttpServletRequest req) {
        AttendeeService as = new AttendeeService();
        List<Attendees> attendeesList = as.getAllAttendees();
        req.setAttribute("profiles", attendeesList);
        System.out.println("---saveAttendeesInRequest---");
        for (Attendees attendees : attendeesList) {
            System.out.println(attendees);
        }
    }
    private void saveAttendeeInfoInRequest(HttpServletRequest req, int num) throws IndexOutOfBoundsException {
        AttendeeService as = new AttendeeService();
        List<Attendees> attendeesList = as.getAllAttendees();
        req.setAttribute("profile_info", attendeesList.get(num-1));
        Attendees a = attendeesList.get(num-1);

        System.out.println("---saveAttendeeInfoInRequest---");
        System.out.println(a);
        System.out.println("Number of user: " + (num));
    }
    private void saveAttendeeInfoInRequest(HttpServletRequest req, BigInteger num) throws IndexOutOfBoundsException {
        AttendeeService as = new AttendeeService();
        Attendees a = as.getAttendeeByFK(num);
        req.setAttribute("profile_info", a);

        System.out.println("---saveAttendeeInfoInRequest---");
        System.out.println(a);
        System.out.println("Number of user: " + (num));
    }

}
