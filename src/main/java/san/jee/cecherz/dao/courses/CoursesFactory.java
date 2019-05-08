package san.jee.cecherz.dao.courses;

import san.jee.cecherz.dao.GenericFactory;
import san.jee.cecherz.model.Courses;

import java.math.BigInteger;
import java.util.List;

public interface CoursesFactory extends GenericFactory<Courses, BigInteger> {
    List<Courses> getAll();
}
