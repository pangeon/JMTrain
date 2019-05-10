package san.jee.cecherz.dao.attendees;

import san.jee.cecherz.dao.GenericFactory;
import san.jee.cecherz.model.Attendees;
import san.jee.cecherz.model.Profiles;

import java.math.BigInteger;
import java.util.List;

public interface AttendeeFactory extends GenericFactory<Attendees, BigInteger>  {
    List<Attendees> getAll();
    Attendees getProfileInfo(BigInteger FK);
}
