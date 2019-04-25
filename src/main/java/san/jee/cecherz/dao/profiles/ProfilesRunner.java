package san.jee.cecherz.dao.profiles;

import san.jee.cecherz.dao.profiles.ProfilesFactory;
import san.jee.cecherz.model.Profiles;

import java.math.BigInteger;
import java.util.List;

public class ProfilesRunner implements ProfilesFactory {

    @Override
    public Profiles create(Profiles newObject) {
        return null;
    }

    @Override
    public Profiles read(BigInteger primaryKey) {
        return null;
    }

    @Override
    public boolean update(Profiles updateObject) {
        return false;
    }

    @Override
    public boolean delete(BigInteger key) {
        return false;
    }

    @Override
    public List<Profiles> getAll() {
        return null;
    }
}
