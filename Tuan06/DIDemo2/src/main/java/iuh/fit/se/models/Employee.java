package iuh.fit.se.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Employee {
    private int id;
    @Autowired(required = false)
    @Qualifier("getName5")
    private String name;
    @Autowired(required = false)
    @Qualifier("address5")
    private Address address;

    @Autowired
    public Employee(@Value("5") int id) {
        this.id = id;
    }
}
