package iuh.fit.se.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String mobileNumber;
    private boolean gender;
    private String address;
    private String city;
    private String pinCode;
    private String state;
    private String country;
    private String hobbies;
    private String course;
}
