package san.jee.cecherz.dao.workplace;

import san.jee.cecherz.dao.GenericFactory;
import san.jee.cecherz.model.Workplace;

import java.math.BigInteger;
import java.util.List;

public interface WorkplaceFactory extends GenericFactory<Workplace, BigInteger> {
    List<Workplace> getAll();
}
