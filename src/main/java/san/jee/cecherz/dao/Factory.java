package san.jee.cecherz.dao;

import san.jee.cecherz.dao.attendees.AttendeeFactory;
import san.jee.cecherz.dao.courses.CoursesFactory;
import san.jee.cecherz.dao.profiles.ProfilesFactory;
import san.jee.cecherz.dao.subscribtions.SubscribtionsFactory;
import san.jee.cecherz.dao.workplace.WorkplaceFactory;

public abstract class Factory {
    public abstract ProfilesFactory getProfilesFactory();
    public abstract AttendeeFactory getAttendeeFactory();
    public abstract CoursesFactory getCoursesFactory();
    public abstract WorkplaceFactory getWorkplaceFactory();
    public abstract SubscribtionsFactory getSubscribtionsFactory();
}
