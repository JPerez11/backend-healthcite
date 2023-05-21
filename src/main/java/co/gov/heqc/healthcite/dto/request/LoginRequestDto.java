package co.gov.heqc.healthcite.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {


    @Email(message = "Mail must be in a valid format")
    @NotBlank(message = "The email field cannot be empty")
    private String email;
    @NotBlank(message = "The password field cannot be empty")
    private String password;

}
