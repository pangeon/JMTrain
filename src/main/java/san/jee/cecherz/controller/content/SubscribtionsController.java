package san.jee.cecherz.controller.content;

import org.springframework.dao.DuplicateKeyException;
import san.jee.cecherz.model.Attendees;
import san.jee.cecherz.model.Courses;
import san.jee.cecherz.model.Profiles;
import san.jee.cecherz.service.AttendeeService;
import san.jee.cecherz.service.SubscribtionsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

@WebServlet(name = "SubscribtionsController", value = "/subscribtions")
public class SubscribtionsController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        if (req.getUserPrincipal() != null) {
            try {
                insertSubscribtionForUser(req, resp);
            } catch(NullPointerException e) {
                req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, resp);
            }
            req.getRequestDispatcher("/WEB-INF/info.jsp").forward(req, resp);
        } else {
            sendError(req, resp, "error");
        }
        System.out.println("--doGet() | SubscribtionsController--");
        System.out.println("action:" + action);
    }

    // Metoda nie obsługuje tabeli Workplace - niezbędne modyfikacje
    private void insertSubscribtionForUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            req.setCharacterEncoding("UTF-8");
            String courseId = req.getParameter("id");
            BigInteger PK = new BigInteger(courseId);
            Courses course = new Courses(PK);

            //Workplace workplace = null;

            Profiles profiles = (Profiles) req.getSession().getAttribute("user");
            BigInteger FK = profiles.getId();
            AttendeeService as = new AttendeeService();
            Attendees attendee = as.getAttendeeByFK(FK);

            if (req.getUserPrincipal() != null) {
                SubscribtionsService ss = new SubscribtionsService();
                ss.addNewSubscribtion(course, attendee);
                req.getRequestDispatcher("/WEB-INF/info.jsp").forward(req, resp);
            } else {
                resp.sendError(403);
            }
            System.out.println("--insertSubscribtionForUser | SubscribtionsController--");
            System.out.println("course: " + course.getId());
            //System.out.println("workplace: " + Objects.requireNonNull(workplace).getName());
            System.out.println("attendee: " + attendee.getName());
        } catch(DuplicateKeyException e) {
            sendError(req, resp, "info_exist");
            System.out.println("--DuplicateKeyException--");
        }
    }
    private void sendError(HttpServletRequest req, HttpServletResponse resp, String URL) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/" + URL + ".jsp").forward(req, resp);
    }
}
