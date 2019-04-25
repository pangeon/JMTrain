package san.jee.cecherz.dao.workplace;

import san.jee.cecherz.model.Workplace;

import java.math.BigInteger;
import java.util.List;

public class WorkplaceRunner implements WorkplaceFactory {
    @Override
    public Workplace create(Workplace newObject) {
        return null;
    }

    @Override
    public Workplace read(BigInteger primaryKey) {
        return null;
    }

    @Override
    public boolean update(Workplace updateObject) {
        return false;
    }

    @Override
    public boolean delete(BigInteger key) {
        return false;
    }

    @Override
    public List<Workplace> getAll() {
        return null;
    }
}
