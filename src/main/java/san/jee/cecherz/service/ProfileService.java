package san.jee.cecherz.service;

import san.jee.cecherz.dao.Factory;
import san.jee.cecherz.dao.exception.UnknownRoleException;
import san.jee.cecherz.dao.profiles.ProfilesFactory;
import san.jee.cecherz.model.Profiles;
import san.jee.cecherz.model.Role;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ProfileService {
    /*
    addProfile() - odpowiedzialna za utworzenie obiektu klasy Profiles i zapisanie odpowiednich danych w bazie.
    Argumenty metody będą pochodziły z żądania przesłanego do właściwego kontrolera.
     */
    public void addProfile(String email, String password, Role role, String ip, String token) throws UnknownRoleException {
        Profiles profile = new Profiles();
        profile.setEmail(email);
        String md5pass = encryptPass(password);
        profile.setPassword(md5pass);
        profile.setRole(role);
        profile.setIp(ip);
        profile.setToken(token);
        Factory factory = Factory.getFactory();
        ProfilesFactory profilesFactory = factory.getProfilesFactory();
        profilesFactory.create(profile);
    }
    public String encryptPass(String pass) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        digest.update(pass.getBytes());
        String md5pass = new BigInteger(1, digest.digest()).toString(16);
        return md5pass;

    }
    public Profiles getProfileById(BigInteger id) {
        Factory factory = Factory.getFactory();
        ProfilesFactory profilesFactory = factory.getProfilesFactory();
        Profiles profile = profilesFactory.read(id);
        return profile;
    }
    public Profiles getProfileByEmail(String email) {
        Factory factory = Factory.getFactory();
        ProfilesFactory profilesFactory = factory.getProfilesFactory();
        Profiles profile = profilesFactory.getProfilesByEmail(email);
        return profile;
    }
}
