package iuh.fit.se.entities;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String role;
    private String name;

    public Employee(String role, String name) {
        this.role = role;
        this.name = name;
    }
}
