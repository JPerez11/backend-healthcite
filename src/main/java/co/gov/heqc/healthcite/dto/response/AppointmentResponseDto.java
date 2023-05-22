package co.gov.heqc.healthcite.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponseDto {

    private String description;
    private LocalDateTime attentionDate;
    private LocalDateTime citationDate;
    private String active;
    private String reason;
    private String symptoms;
    private String eps;
    private String patientName;

}
