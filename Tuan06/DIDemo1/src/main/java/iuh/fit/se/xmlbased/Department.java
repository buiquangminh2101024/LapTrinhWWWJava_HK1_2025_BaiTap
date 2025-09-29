package iuh.fit.se.xmlbased;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
    private String id;
    private String name;
    private Faculty faculty;

    public Department(Faculty faculty) {
        this.faculty = faculty;
    }
}
