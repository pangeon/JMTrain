package san.jee.cecherz.dao;

import org.springframework.dao.DuplicateKeyException;

import java.io.Serializable;
import java.util.List;

public interface GenericFactory<T, PK extends Serializable> {
    T create(T newObject) throws DuplicateKeyException;
    T read(PK primaryKey);
    boolean update(T updateObject);
    boolean delete(T key);
    List<T> getAll();
}
