package san.jee.cecherz.dao;

import san.jee.cecherz.dao.attendees.AttendeeFactory;
import san.jee.cecherz.dao.courses.CoursesFactory;
import san.jee.cecherz.dao.exception.DbTypeException;
import san.jee.cecherz.dao.profiles.ProfilesFactory;
import san.jee.cecherz.dao.subscribtions.SubscribtionsFactory;
import san.jee.cecherz.dao.workplace.WorkplaceFactory;

public abstract class Factory {

    /* MySQL - 1 */
    public static final int DB_FACTORY = 1;

    public abstract ProfilesFactory getProfilesFactory();
    public abstract AttendeeFactory getAttendeeFactory();
    public abstract CoursesFactory getCoursesFactory();
    public abstract WorkplaceFactory getWorkplaceFactory();
    public abstract SubscribtionsFactory getSubscribtionsFactory();

    public static Factory getFactory() {
        Factory factory = null;
        try {
            factory = getFactory(DB_FACTORY);
        } catch (DbTypeException e) {
            e.printStackTrace();
        }
        return factory;
    }
    /*
    zmieniając w tej klasie kilka linijek kodu w metodach getFactory()
    można przepiąć aplikację na inny silnik
     */
    private static Factory getFactory(int type) throws DbTypeException {
        switch (type) {
            case DB_FACTORY:
                return new DbFactory();
            default:
                throw new DbTypeException();
        }
    }
}
