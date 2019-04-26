package san.jee.cecherz.dao;

import san.jee.cecherz.dao.attendees.AttendeeFactory;
import san.jee.cecherz.dao.attendees.AttendeeRunner;
import san.jee.cecherz.dao.courses.CoursesFactory;
import san.jee.cecherz.dao.courses.CoursesRunner;
import san.jee.cecherz.dao.profiles.ProfilesFactory;
import san.jee.cecherz.dao.profiles.ProfilesRunner;
import san.jee.cecherz.dao.subscribtions.SubscribtionsFactory;
import san.jee.cecherz.dao.subscribtions.SubscribtionsRunner;
import san.jee.cecherz.dao.workplace.WorkplaceFactory;
import san.jee.cecherz.dao.workplace.WorkplaceRunner;

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
    public WorkplaceFactory getWorkplaceFactory() {
        return new WorkplaceRunner();
    }
    @Override
    public SubscribtionsFactory getSubscribtionsFactory() {
        return new SubscribtionsRunner();
    }

}
