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
public class EpsResponseDto {

    private String name;
    private String nit;
    private LocalDate foundationDate;
    private String address;
    private String phone;

}
