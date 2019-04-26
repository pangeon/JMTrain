package san.jee.cecherz.service;

import san.jee.cecherz.dao.Factory;
import san.jee.cecherz.dao.exception.UnknownRoleException;
import san.jee.cecherz.dao.profiles.ProfilesFactory;
import san.jee.cecherz.model.Profiles;
import san.jee.cecherz.model.Role;

public class ProfileService {
    /*
    addProfile() - odpowiedzialna za utworzenie obiektu klasy Profiles i zapisanie odpowiednich danych w bazie.
    Argumenty metody będą pochodziły z żądania przesłanego do właściwego kontrolera.
     */
    public void addProfile(String email, String password, Role role) throws UnknownRoleException {
        Profiles profile = new Profiles();
        profile.setEmail(email);
        profile.setPassword(password);
        profile.setRole(role); // rola określona domyślnie
        Factory factory = Factory.getFactory();
        ProfilesFactory profilesFactory = factory.getProfilesFactory();
        profilesFactory.create(profile);
    }
}
