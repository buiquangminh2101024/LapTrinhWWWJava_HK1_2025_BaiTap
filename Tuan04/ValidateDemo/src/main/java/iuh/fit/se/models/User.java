package iuh.fit.se.models;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int id;
    @NotNull(message = "Name must be not null")
    @NotEmpty(message = "Name must be not empty")
    @Size(min = 8, max = 50, message = "Name must be between 8 and 50 characters")
    private String name;
    @NotEmpty(message = "Email must be not empty")
    @Email
    private String email;
    private String country;

    public User(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }
}
