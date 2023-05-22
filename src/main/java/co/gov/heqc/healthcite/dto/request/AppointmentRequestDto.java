package co.gov.heqc.healthcite.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequestDto {

    private String description;
    private LocalDateTime attentionDate;
    private LocalDateTime citationDate;
    private String active = "PENDING";
    private String reason;
    private String symptoms;
    private String epsName;
    private String patientDocument;
    private String doctorDocument;

}
