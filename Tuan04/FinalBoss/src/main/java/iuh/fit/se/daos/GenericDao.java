package iuh.fit.se.daos;

import java.util.List;
import java.util.Set;

public interface GenericDao<T> {
    public void save(T t);
    public void update(T t);
    public void delete(int id);
    public T findByID(int id);
    public List<T> getAll();
}
