package iuh.fit.se.daos.impl;

import iuh.fit.se.daos.EmployeeDao;
import iuh.fit.se.daos.mappers.EmployeeMapper;
import iuh.fit.se.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource DataSource) {
        this.jdbcTemplate = new JdbcTemplate(DataSource);
    }

    @Override
    public void update(Employee employee) {
        String sql = "update employees set name=?, role=? where id=?";
        jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getId());
    }

    @Override
    public List<Employee> getAll() {
        String sql = "select * from employees";
        return jdbcTemplate.query(sql, new EmployeeMapper());
    }

    @Override
    public Employee getById(int id) {
        String sql = "select * from employees where id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from employees where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void save(Employee employee) {
        String sql1 = "insert into employees(id, role, name) values (?,?,?)";
        String sql2 = "insert into employees(role, name) values (?,?)";
        if (employee.getId() != 0)
            jdbcTemplate.update(sql1, employee.getId(), employee.getRole(), employee.getName());
        else
            jdbcTemplate.update(sql2, employee.getRole(), employee.getName());
    }

    @Override
    public Employee getByIdDirectMapper(int id) {
        String sql = "select * from employees where id=?";
        return jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> new Employee(
                        rs.getInt("id"),
                        rs.getString("role"),
                        rs.getString("name")),
                id);
    }
}
