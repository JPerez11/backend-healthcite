package co.gov.heqc.healthcite.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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

    @NotBlank(message = "The description field cannot be empty")
    private String description;
    @Past(message = "Must be a past date")
    @NotNull(message = "The attention date field cannot be empty")
    private LocalDateTime attentionDate;
    @Future(message = "The citation date must be for the furute")
    @NotNull(message = "The citation date field cannot be empty")
    private LocalDateTime citationDate;
    private String status = "PENDING";
    @NotBlank(message = "The reason field cannot be empty")
    private String reason;
    @NotBlank(message = "The symptoms field cannot be empty")
    private String symptoms;
    @NotBlank(message = "The EPS's name field cannot be empty")
    private String epsName;
    @NotBlank(message = "The patient document field cannot be empty")
    private String patientDocument;
    @NotBlank(message = "The doctor document field cannot be empty")
    private String doctorDocument;

}
