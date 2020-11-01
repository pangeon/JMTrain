package san.jee.cecherz.dao;

import san.jee.cecherz.dao.attendees.AttendeeFactory;
import san.jee.cecherz.dao.courses.CoursesFactory;
import san.jee.cecherz.dao.exception.DbTypeException;
import san.jee.cecherz.dao.profiles.ProfilesFactory;
import san.jee.cecherz.dao.subscribtions.SubscriptionsFactory;
import san.jee.cecherz.dao.workplace.WorkplacesFactory;

public abstract class Factory {
    public static final int DB_FACTORY = 1;

    public abstract ProfilesFactory getProfilesFactory();
    public abstract AttendeeFactory getAttendeeFactory();
    public abstract CoursesFactory getCoursesFactory();
    public abstract WorkplacesFactory getWorkplacesFactory();
    public abstract SubscriptionsFactory getSubscriptionsFactory();

    public static Factory getFactory() {
        Factory factory = null;
        try {
            factory = getFactory(DB_FACTORY);
        } catch (DbTypeException e) {
            e.printStackTrace();
        }
        return factory;
    }
    private static Factory getFactory(int type) throws DbTypeException {
        switch (type) {
            case DB_FACTORY:
                return new DbFactory();
            default:
                throw new DbTypeException();
        }
    }
}
