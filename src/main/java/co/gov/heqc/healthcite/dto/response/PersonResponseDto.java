package co.gov.heqc.healthcite.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponseDto {

    private String firstName;
    private String lastName;
    private String document;
    private String phone;
    private String address;
    private LocalDate birthdate;
    private String gender;
    private String email;
    private String roleName;

}
