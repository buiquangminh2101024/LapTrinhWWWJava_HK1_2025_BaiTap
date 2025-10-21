package iuh.fit.se.services.impl;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.repositories.EmployeeRepository;
import iuh.fit.se.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee add(Employee employee) {
        boolean areNotExist = findById(employee.getId()) == null;
        return areNotExist? employeeRepository.save(employee): null;
    }

    @Override
    public Employee update(Employee employee) {
        boolean areExist = findById(employee.getId()) != null;
        return areExist? employeeRepository.save(employee): null;
    }

    @Override
    public void delete(int id) {
        Employee employee = findById(id);
        if (employee != null)
            employeeRepository.delete(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByFirstNameContainingOrLastNameContainingOrEmailContaining(String text) {
        return employeeRepository.findByFirstNameContainingOrLastNameContainingOrEmailContaining(text, text, text);
    }
}
