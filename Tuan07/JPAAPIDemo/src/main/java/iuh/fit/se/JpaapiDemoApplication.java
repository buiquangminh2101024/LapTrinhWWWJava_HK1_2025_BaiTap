package iuh.fit.se;

import iuh.fit.se.entities.Department;
import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.DepartmentService;
import iuh.fit.se.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaapiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaapiDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeService employeeService, DepartmentService departmentService) {
        return args -> {
            Employee employee1 = new Employee("Super Admin", "Bùi Quang Minh");
            Department department1 = new Department("CNTT");
            employee1.setDepartment(department1);

            departmentService.save(department1);
            employeeService.save(employee1);

            System.out.println(departmentService.findAll());
            System.out.println(employeeService.findAll());
        };
    }
}
