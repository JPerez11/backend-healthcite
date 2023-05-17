package co.gov.heqc.healthcite.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "PEOPLE")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeopleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    @NotBlank(message = "The first name field cannot be empty")
    private String firstName;
    @Column(name = "last_name")
    @NotBlank(message = "The last name field cannot be empty")
    private String lastName;
    @Column(length = 14, unique = true)
    @NotBlank(message = "The document field cannot be empty")
    @Pattern(regexp = "^\\d{14}$", message = "The document field must contain numbers and a maximum of 14 characters")
    private String document;
    @Column(length = 14)
    @NotBlank(message = "The phone field cannot be empty")
    @Pattern(regexp = "^\\+?\\d{14}$", message = "The phone field must contain numbers and a maximum of 14 characters")
    private String phone;
    @Column(nullable = false)
    @NotBlank(message = "The address field cannot be empty")
    private String address;
    @Column(nullable = false)
    @NotNull(message = "The birthdate field cannot be empty")
    @Past(message = "Must be a past date")
    private LocalDate birthdate;
    @Column(nullable = false)
    @NotBlank(message = "The gender field cannot be empty")
    private String gender;
    @Column(nullable = false, unique = true)
    @Email(message = "Mail must be in a valid format")
    @NotBlank(message = "The email field cannot be empty")
    private String email;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "The username cannot be empty")
    private String username;
    @Column(nullable = false)
    @NotBlank(message = "The password field cannot be empty")
    private String password;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private RoleEntity role;

}
