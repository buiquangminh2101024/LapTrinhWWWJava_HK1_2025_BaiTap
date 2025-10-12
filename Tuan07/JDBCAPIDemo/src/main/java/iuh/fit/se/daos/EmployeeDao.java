package iuh.fit.se.daos;

import iuh.fit.se.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeDao {
    void update(Employee employee);
    List<Employee> getAll();
    Employee getById(int id);
    void deleteById(int id);
    void save(Employee employee);
    Employee getByIdDirectMapper(int id);
}
