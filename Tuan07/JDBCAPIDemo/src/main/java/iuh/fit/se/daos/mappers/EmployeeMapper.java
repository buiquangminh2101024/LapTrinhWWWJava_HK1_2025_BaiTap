package iuh.fit.se.daos.mappers;

import iuh.fit.se.entities.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setRole(rs.getString("role"));
        employee.setName(rs.getString("name"));
        return employee;
    }
}
