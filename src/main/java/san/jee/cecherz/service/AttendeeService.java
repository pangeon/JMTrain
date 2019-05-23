package san.jee.cecherz.service;

import san.jee.cecherz.dao.Factory;
import san.jee.cecherz.dao.attendees.AttendeeFactory;
import san.jee.cecherz.model.Attendees;
import san.jee.cecherz.model.Profiles;

import java.math.BigInteger;
import java.util.List;

public class AttendeeService {
    public void addProfileInfo(Profiles idprof, String name, String surname,
            String phone, String city, String postcode, String street) {
            Attendees a = createAttendeInfo(
                    idprof, name, surname,
                    phone, city, postcode, street);
            Factory f = Factory.getFactory();
            AttendeeFactory af = f.getAttendeeFactory();
            af.create(a);
    }
    public List<Attendees> getAllAttendees() {
        Factory f = Factory.getFactory();
        AttendeeFactory af = f.getAttendeeFactory();
        List<Attendees> attendeesList = af.getAll();
        return attendeesList;
    }
    public Attendees getAttendeeByID(BigInteger id) {
        Factory factory = Factory.getFactory();
        AttendeeFactory attendeeFactory = factory.getAttendeeFactory();
        Attendees attendee = attendeeFactory.getProfileInfo(id);
        return attendee;
    }
    private Attendees createAttendeInfo
    (Profiles idprof, String name, String surname, String phone, String city, String postcode,
     String street) {
        Attendees a = new Attendees();
        Profiles pcopy = new Profiles(idprof);
        a.setIdprof(pcopy);
        a.setName(name);
        a.setSurname(surname);
        a.setPhone(phone);
        a.setCity(city);
        a.setPostcode(postcode);
        a.setStreet(street);
        return a;
    }
}
