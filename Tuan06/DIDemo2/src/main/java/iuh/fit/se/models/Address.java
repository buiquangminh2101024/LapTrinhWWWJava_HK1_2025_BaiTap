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
@Component("address5")
public class Address {
    @Value("${city5}")
    private String city;
    @Value("${state5}")
    private String state;
    @Value("${country5}")
    private String country;
}
