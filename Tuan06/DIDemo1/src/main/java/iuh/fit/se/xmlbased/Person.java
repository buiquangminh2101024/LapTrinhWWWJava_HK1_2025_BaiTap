package iuh.fit.se.xmlbased;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private int age;
    private List<Address> addresses;
    private List<String> email;
    private String name;
}
