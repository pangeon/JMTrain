package san.jee.cecherz.content;

import san.jee.cecherz.model.Courses;
import san.jee.cecherz.service.CoursesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "CoursesController", value = "/courses")
public class CoursesController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        saveCoursesInRequest(req);
        req.getRequestDispatcher("start.jsp").forward(req, resp);
    }

    private void saveCoursesInRequest(HttpServletRequest req) {
        CoursesService cs = new CoursesService();
        List<Courses> cl = cs.getAllCourses(Comparator.comparing(Courses::getStart_date));
        req.setAttribute("courses", cl);
    }
}
