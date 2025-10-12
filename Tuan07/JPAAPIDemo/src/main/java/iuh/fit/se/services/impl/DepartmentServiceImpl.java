package iuh.fit.se.services.impl;

import iuh.fit.se.entities.Department;
import iuh.fit.se.repositories.DepartmentRepository;
import iuh.fit.se.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @Override
    public Department save(Department employee) {
        return departmentRepository.save(employee);
    }

    @Override
    public Department update(Department department) {
        if (departmentRepository.existsById(department.getDeptId()))
            return departmentRepository.save(department);
        else
            return null;
    }

    @Override
    public void delete(int id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department findById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
