package san.jee.cecherz.dao.attendees;

import san.jee.cecherz.model.Attendees;
import san.jee.cecherz.model.Profiles;

import java.math.BigInteger;
import java.util.List;

public class AttendeeRunner implements AttendeeFactory {
    @Override
    public Attendees create(Attendees newObject) {
        return null;
    }

    @Override
    public Attendees read(BigInteger primaryKey) {
        return null;
    }

    @Override
    public boolean update(Attendees updateObject) {
        return false;
    }

    @Override
    public boolean delete(BigInteger key) {
        return false;
    }

    @Override
    public List<Attendees> getAll() {
        return null;
    }

    @Override
    public Profiles getProfileByFK(BigInteger ForeignKey) {
        return null;
    }
}
