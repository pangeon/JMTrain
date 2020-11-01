package san.jee.cecherz.dao.workplace;

import san.jee.cecherz.dao.GenericFactory;
import san.jee.cecherz.model.Workplaces;

import java.math.BigInteger;
import java.util.List;

public interface WorkplacesFactory extends GenericFactory<Workplaces, BigInteger> {
    List<Workplaces> getAll();
}
