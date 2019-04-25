package san.jee.cecherz.dao;

import san.jee.cecherz.dao.attendees.AttendeeFactory;
import san.jee.cecherz.dao.attendees.AttendeeRunner;
import san.jee.cecherz.dao.profiles.ProfilesFactory;
import san.jee.cecherz.dao.profiles.ProfilesRunner;

public class DbFactory extends Factory {

    @Override
    public ProfilesFactory getProfilesFactory() {
        return new ProfilesRunner();
    }

    @Override
    public AttendeeFactory getAttendeeFactory() {
        return new AttendeeRunner();
    }
}
