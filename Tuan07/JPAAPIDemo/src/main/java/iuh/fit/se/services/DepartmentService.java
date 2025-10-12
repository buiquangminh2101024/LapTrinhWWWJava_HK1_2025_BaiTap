package iuh.fit.se.services;

import iuh.fit.se.entities.Department;
import iuh.fit.se.entities.Employee;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);

    Department update(Department department);

    void delete(int department);

    Department findById(int department);

    List<Department> findAll();
}
