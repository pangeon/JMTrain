package san.jee.cecherz.dao.subscribtions;

import san.jee.cecherz.dao.GenericFactory;
import san.jee.cecherz.model.*;

import java.math.BigInteger;
import java.util.List;

public interface SubscribtionsFactory extends GenericFactory<Subscriptions, BigInteger> {
    List<Subscriptions> getAll();
    Attendees getAttendeeByFK(BigInteger ForeignKey);
    Courses getCourseByFK(BigInteger ForeignKey);
    Workplaces getWorkplaceByFK(BigInteger ForeignKey);
}
