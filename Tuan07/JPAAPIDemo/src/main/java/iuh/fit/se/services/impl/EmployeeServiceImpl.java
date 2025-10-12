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
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        if (employeeRepository.existsById(employee.getId()))
            return employeeRepository.save(employee);
        else
            return null;
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
