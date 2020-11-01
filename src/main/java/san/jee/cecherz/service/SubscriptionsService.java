package san.jee.cecherz.service;

import org.springframework.dao.DuplicateKeyException;
import san.jee.cecherz.dao.Factory;
import san.jee.cecherz.dao.subscribtions.SubscriptionsFactory;
import san.jee.cecherz.model.Attendees;
import san.jee.cecherz.model.Courses;
import san.jee.cecherz.model.Subscriptions;

public class SubscriptionsService {
    public void addNewSubscribtion(Courses c, Attendees a) throws DuplicateKeyException {
        Subscriptions s = createNewSubscribtion(c, a);
        Factory f = Factory.getFactory();
        SubscriptionsFactory sf = f.getSubscriptionsFactory();
        sf.create(s);
    }
    private Subscriptions createNewSubscribtion(Courses c, Attendees a) {
        Subscriptions s = new Subscriptions();
        Courses ccpopy = new Courses(c);
        Attendees acopy = new Attendees(a);
        s.setCourse(ccpopy);
        s.setAttendee(acopy);
        return s;
    }
}
