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
public class AppointPatientResponseDto {

    private Long id;
    private String description;
    private LocalDateTime citationDate;
    private String status;
    private String doctorName;
    private String doctorDocument;
    private String doctorPhone;
    private String eps;


}
