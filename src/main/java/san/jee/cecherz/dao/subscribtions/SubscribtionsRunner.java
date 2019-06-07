package san.jee.cecherz.dao.subscribtions;

import san.jee.cecherz.model.Attendees;
import san.jee.cecherz.model.Courses;
import san.jee.cecherz.model.Subscribtions;
import san.jee.cecherz.model.Workplace;

import java.math.BigInteger;
import java.util.List;

public class SubscribtionsRunner implements SubscribtionsFactory {
    @Override
    public Subscribtions create(Subscribtions newObject) {
        return null;
    }

    @Override
    public Subscribtions read(BigInteger primaryKey) {
        return null;
    }

    @Override
    public boolean update(Subscribtions updateObject) {
        return false;
    }

    @Override
    public boolean delete(Subscribtions key) {
        return false;
    }

    @Override
    public List<Subscribtions> getAll() {
        return null;
    }

    @Override
    public Attendees getAttendeeByFK(BigInteger ForeignKey) {
        return null;
    }

    @Override
    public Courses getCourseByFK(BigInteger ForeignKey) {
        return null;
    }

    @Override
    public Workplace getWorkplaceByFK(BigInteger ForeignKey) {
        return null;
    }
}
