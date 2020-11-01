package san.jee.cecherz.service;

import san.jee.cecherz.dao.Factory;
import san.jee.cecherz.dao.exception.UnknownRoleException;
import san.jee.cecherz.dao.profiles.ProfilesFactory;
import san.jee.cecherz.model.Profiles;
import san.jee.cecherz.model.Role;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.List;

public class ProfileService {
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
    public Profiles getProfileForActivation(String email, String token) {
        Factory factory = Factory.getFactory();
        ProfilesFactory profilesFactory = factory.getProfilesFactory();
        Profiles profile = profilesFactory.getProfilesForActivation(email, token);
        return profile;
    }
    public List<Profiles> getAllProfiles() {
        return getAllProfiles(null);
    }
    public List<Profiles> getAllProfiles(Comparator<Profiles> comp) {
        Factory factory = Factory.getFactory();
        ProfilesFactory pfactory = factory.getProfilesFactory();
        List<Profiles> profilesList = pfactory.getAll();
        if (comp != null && profilesList != null) {
            profilesList.sort(comp);
        }
        return profilesList;
    }
    public Profiles updateProfilePassword(String email, String password) {
        Factory factory = Factory.getFactory();
        ProfilesFactory pfactory = factory.getProfilesFactory();
        Profiles profileToUpdate = pfactory.getProfilesByEmail(email);
        if(profileToUpdate != null) {
            String md5pass = encryptPass(password);
            profileToUpdate.setPassword(md5pass);
            pfactory.update(profileToUpdate);
        } else {
            System.out.println("Profile is null !");
        }
        System.out.println("--updateProfilePassword--");
        System.out.println("password: " + profileToUpdate.getPassword());
        return profileToUpdate;
    }
    public Profiles updateProfileStatus(String email, String token) {
        Factory factory = Factory.getFactory();
        ProfilesFactory pfactory = factory.getProfilesFactory();
        Profiles profileToUpdate = pfactory.getProfilesForActivation(email, token);
        if(profileToUpdate != null) {
            profileToUpdate.setActive(1);
            pfactory.activate(profileToUpdate);
        } else {
            System.out.println("Profile is null !");
        }
        return profileToUpdate;
    }
    public void deleteProfile(String email) {
        Factory factory = Factory.getFactory();
        ProfilesFactory pfactory = factory.getProfilesFactory();
        Profiles profileToDelete = pfactory.getProfilesByEmail(email);
        if(profileToDelete != null) {
            pfactory.delete(profileToDelete);
        } else {
            System.out.println("Profile is null !");
        }
        System.out.println("--deleteProfile--");
        System.out.println("email: " + profileToDelete.getEmail());
    }
}
