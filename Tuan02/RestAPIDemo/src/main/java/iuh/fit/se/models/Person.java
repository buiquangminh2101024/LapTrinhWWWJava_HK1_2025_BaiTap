package iuh.fit.se.models;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String id;
    private String name;
    private int age;
    private LocalDateCustom dob;

    public Person(String name, int age, LocalDateCustom dob) {
        this.name = name;
        this.age = age;
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
