package iuh.fit.se.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
    }
}
