package san.jee.cecherz.dao;

import san.jee.cecherz.dao.attendees.AttendeeFactory;
import san.jee.cecherz.dao.attendees.AttendeeRunner;
import san.jee.cecherz.dao.courses.CoursesFactory;
import san.jee.cecherz.dao.courses.CoursesRunner;
import san.jee.cecherz.dao.profiles.ProfilesFactory;
import san.jee.cecherz.dao.profiles.ProfilesRunner;
import san.jee.cecherz.dao.subscribtions.SubscriptionsFactory;
import san.jee.cecherz.dao.subscribtions.SubscriptionsRunner;
import san.jee.cecherz.dao.workplace.WorkplacesFactory;
import san.jee.cecherz.dao.workplace.WorkplacesRunner;

public class DbFactory extends Factory {

    @Override
    public ProfilesFactory getProfilesFactory() {
        return new ProfilesRunner();
    }
    @Override
    public AttendeeFactory getAttendeeFactory() {
        return new AttendeeRunner();
    }
    @Override
    public CoursesFactory getCoursesFactory() {
        return new CoursesRunner();
    }
    @Override
    public WorkplacesFactory getWorkplacesFactory() {
        return new WorkplacesRunner();
    }
    @Override
    public SubscriptionsFactory getSubscriptionsFactory() {
        return new SubscriptionsRunner();
    }

}
