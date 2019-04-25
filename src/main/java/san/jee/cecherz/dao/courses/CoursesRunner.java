package san.jee.cecherz.dao.courses;

import san.jee.cecherz.model.Courses;
import san.jee.cecherz.model.Profiles;

import java.math.BigInteger;
import java.util.List;

public class CoursesRunner implements CoursesFactory {
    @Override
    public Courses create(Courses newObject) {
        return null;
    }

    @Override
    public Courses read(BigInteger primaryKey) {
        return null;
    }

    @Override
    public boolean update(Courses updateObject) {
        return false;
    }

    @Override
    public boolean delete(BigInteger key) {
        return false;
    }

    @Override
    public List<Courses> getAll() {
        return null;
    }

    @Override
    public Profiles getTrainerByFK(BigInteger ForeignKey) {
        return null;
    }
}
