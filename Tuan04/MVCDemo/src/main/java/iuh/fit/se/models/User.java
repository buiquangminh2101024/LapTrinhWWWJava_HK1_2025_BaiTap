package iuh.fit.se.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "First Name cannot empty")
    private String firstName;
    @NotEmpty(message = "Last Name cannot empty")
    private String lastName;
    @NotEmpty(message = "Email cannot empty")
    @Email(message = "Incorrect email format")
    private String email;
    @NotEmpty(message = "Password cannot empty")
    private String password;
    @NotNull(message = "Must not be missing birthday")
    private LocalDate birthday;
    @NotNull(message = "Must not be missing gender")
    private String gender;

    public User(String firstName, String lastName, String email, String password, LocalDate birthday, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.gender = gender;
    }
}
