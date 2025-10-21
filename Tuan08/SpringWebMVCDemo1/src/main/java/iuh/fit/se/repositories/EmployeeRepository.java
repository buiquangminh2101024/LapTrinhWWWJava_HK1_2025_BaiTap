package iuh.fit.se.repositories;

import iuh.fit.se.entities.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstNameContainingOrLastNameContainingOrEmailContaining(@NotEmpty(message = "First Name không được để trống") String firstName, @NotEmpty(message = "Last Name không được để trống") String lastName, @Email(message = "Email không đúng định dạng") @NotEmpty(message = "Email không được để trống") String email);
}
