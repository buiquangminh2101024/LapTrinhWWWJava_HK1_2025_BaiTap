package iuh.fit.se.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
    private String name;

    @ManyToOne
    private Department department;

    public Employee(String role, String name) {
        this.role = role;
        this.name = name;
    }
}
