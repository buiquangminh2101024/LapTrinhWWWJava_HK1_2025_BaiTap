package iuh.fit.se;

import iuh.fit.se.daos.EmployeeDao;
import iuh.fit.se.entities.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"iuh.fit.se.daos", "iuh.fit.se.daos.impl"})
public class SpringPureJdbAutoConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringPureJdbAutoConfigApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeDao employeeDao) {
        return args -> {
            Employee employee = new Employee(1, "Super Admin", "Nguyễn Văn A");
            employeeDao.save(employee);

            List<Employee> employees = employeeDao.getAll();
            employees.forEach(System.out::println);

            Employee employee2 = employeeDao.getById(1);
            System.out.println(employee2);

            Employee employeeDirectMapper = employeeDao.getByIdDirectMapper(1);
            System.out.println(employeeDirectMapper);

            employeeDao.deleteById(1);
        };
    }
}
