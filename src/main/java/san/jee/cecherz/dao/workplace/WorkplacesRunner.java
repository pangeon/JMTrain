package san.jee.cecherz.dao.workplace;

import san.jee.cecherz.model.Workplaces;

import java.math.BigInteger;
import java.util.List;

public class WorkplacesRunner implements WorkplacesFactory {
    @Override
    public Workplaces create(Workplaces newObject) {
        return null;
    }

    @Override
    public Workplaces read(BigInteger primaryKey) {
        return null;
    }

    @Override
    public boolean update(Workplaces updateObject) {
        return false;
    }

    @Override
    public boolean delete(Workplaces key) {
        return false;
    }

    @Override
    public List<Workplaces> getAll() {
        return null;
    }
}
