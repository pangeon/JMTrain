package san.jee.cecherz.service;

import org.springframework.dao.DuplicateKeyException;
import san.jee.cecherz.dao.Factory;
import san.jee.cecherz.dao.subscribtions.SubscribtionsFactory;
import san.jee.cecherz.model.Attendees;
import san.jee.cecherz.model.Courses;
import san.jee.cecherz.model.Subscribtions;

public class SubscribtionsService {
    // Metoda nie obsługuje tabeli Workplace - niezbędne modyfikacje
    public void addNewSubscribtion(Courses c, Attendees a) throws DuplicateKeyException {
        Subscribtions s = createNewSubscribtion(c, a);
        Factory f = Factory.getFactory();
        SubscribtionsFactory sf = f.getSubscribtionsFactory();
        sf.create(s);
    }
    // Metoda nie obsługuje tabeli Workplace - niezbędne modyfikacje
    private Subscribtions createNewSubscribtion(Courses c, Attendees a) {
        Subscribtions s = new Subscribtions();
        Courses ccpopy = new Courses(c);
        //Workplace wcopy = new Workplace(w);
        Attendees acopy = new Attendees(a);
        s.setCourse(ccpopy);
        //s.setWorkplace(wcopy);
        s.setAttendee(acopy);
        return s;
    }
}
