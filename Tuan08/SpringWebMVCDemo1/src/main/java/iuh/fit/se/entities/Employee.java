package iuh.fit.se.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "First Name không được để trống")
    private String firstName;
    @NotEmpty(message = "Last Name không được để trống")
    private String lastName;
    @Email(message = "Email không đúng định dạng")
    @NotEmpty(message = "Email không được để trống")
    private String email;
    @NotNull(message = "Ngày sinh không được để trống")
    private LocalDate dateOfBirth;
    @Pattern(regexp = "\\d{10}", message = "Số điện thoại phải gồm 10 chữ số")
    private String phone;
    private boolean gender;
    @NotEmpty(message = "Address không được để trống")
    private String address;
}
