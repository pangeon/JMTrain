package san.jee.cecherz.dao.courses;

import san.jee.cecherz.dao.GenericFactory;
import san.jee.cecherz.model.Courses;
import san.jee.cecherz.model.Profiles;

import java.math.BigInteger;
import java.util.List;

public interface CoursesFactory extends GenericFactory<Courses, BigInteger> {
    List<Courses> getAll();
    Profiles getTrainerByFK(BigInteger ForeignKey);
}
