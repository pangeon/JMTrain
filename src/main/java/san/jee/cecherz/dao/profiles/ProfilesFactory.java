package san.jee.cecherz.dao.profiles;

import san.jee.cecherz.dao.GenericFactory;
import san.jee.cecherz.model.Profiles;

import java.math.BigInteger;
import java.util.List;

public interface ProfilesFactory extends GenericFactory<Profiles, BigInteger> {
    List<Profiles> getAll();
    Profiles getProfilesByEmail(String email);
    Profiles getProfilesForActivation(String email, String token);
    boolean activate(Profiles p);
}
