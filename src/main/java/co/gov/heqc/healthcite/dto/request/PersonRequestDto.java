package co.gov.heqc.healthcite.dto.request;

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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequestDto {

    @NotBlank(message = "The first name field cannot be empty")
    private String firstName;
    @NotBlank(message = "The last name field cannot be empty")
    private String lastName;
    @NotBlank(message = "The document field cannot be empty")
    @Pattern(regexp = "^\\d{0,14}$", message = "The document field must contain numbers and a maximum of 14 characters")
    private String document;
    @NotBlank(message = "The phone field cannot be empty")
    @Pattern(regexp = "^\\+?\\d{0,14}$", message = "The phone field must contain numbers and a maximum of 14 " +
            "characters")
    private String phone;
    @NotBlank(message = "The address field cannot be empty")
    private String address;
    @NotNull(message = "The birthdate field cannot be empty")
    @Past(message = "Must be a past date")
    private LocalDate birthdate;
    @NotBlank(message = "The gender field cannot be empty")
    private String gender;
    @Email(message = "Mail must be in a valid format")
    @NotBlank(message = "The email field cannot be empty")
    private String email;
    @NotBlank(message = "The username cannot be empty")
    private String username;
    @NotBlank(message = "The password field cannot be empty")
    private String password;
    @NotNull(message = "The role id cannot be empty")
    private Long idRole;

}
