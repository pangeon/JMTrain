package san.jee.cecherz.service;

import san.jee.cecherz.dao.Factory;
import san.jee.cecherz.dao.courses.CoursesFactory;
import san.jee.cecherz.model.Courses;

import java.util.Comparator;
import java.util.List;

public class CoursesService {
    public List<Courses> getAllCourses() {
        return getAllCourses(null);
    }
    public List<Courses> getAllCourses(Comparator<Courses> comp) {
        Factory factory = Factory.getFactory();
        CoursesFactory cfactory = factory.getCoursesFactory();
        List<Courses> coursesList = cfactory.getAll();
        if(comp != null && coursesList != null) {
            coursesList.sort(comp);
        }
        return coursesList;
    }
}
