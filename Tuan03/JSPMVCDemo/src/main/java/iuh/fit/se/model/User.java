package iuh.fit.se.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthday;
    private String gender;
}
