package san.jee.cecherz.controller.content;

import org.junit.Test;
import san.jee.cecherz.model.Courses;
import san.jee.cecherz.service.CoursesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "CoursesController", value = "/courses")
public class CoursesController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        saveCoursesInRequest(req);
        req.getRequestDispatcher("/WEB-INF/start.jsp").forward(req, resp);
    }
    private void saveCoursesInRequest(HttpServletRequest req) {
        CoursesService service = new CoursesService();
        List<Courses> coursesList = service.getAllCourses(Comparator.comparing(Courses::getStart_date));
        req.setAttribute("courses", coursesList);
        System.out.println("--saveCoursesInRequest--");
        for (Courses course : coursesList) {
            System.out.println(course);
        }
    }
}
