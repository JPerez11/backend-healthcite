package co.gov.heqc.healthcite.dto.request;

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
public class EpsRequestDto {

    @NotBlank(message = "The name field cannot be empty")
    private String name;
    @NotBlank(message = "The nit field cannot be empty")
    @Pattern(regexp = "^\\d{0,14}$", message = "The document field must contain numbers and a maximum of 14 characters")
    private String nit;
    @Past(message = "Must be a past date")
    @NotNull(message = "The foundation date field cannot be empty")
    private LocalDate foundationDate;
    @NotBlank(message = "The address field cannot be empty")
    private String address;
    @NotBlank(message = "The phone field cannot be empty")
    @Pattern(regexp = "^\\+?\\d{0,14}$", message = "The phone field must contain numbers and a maximum of 14 " +
            "characters")
    private String phone;

}
