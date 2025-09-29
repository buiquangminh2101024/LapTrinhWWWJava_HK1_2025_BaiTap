package iuh.fit.se.xmlbased;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private String city;
    private String country;
    private String street;
}
