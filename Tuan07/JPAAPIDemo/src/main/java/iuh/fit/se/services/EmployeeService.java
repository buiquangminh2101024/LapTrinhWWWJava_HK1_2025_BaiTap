package iuh.fit.se.services;

import iuh.fit.se.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    Employee update(Employee employee);

    void delete(int id);

    Employee findById(int id);

    List<Employee> findAll();
}
