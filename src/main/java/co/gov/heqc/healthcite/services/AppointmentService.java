package co.gov.heqc.healthcite.services;

import co.gov.heqc.healthcite.dto.request.AppointmentRequestDto;
import co.gov.heqc.healthcite.dto.response.AppointmentResponseDto;

import java.util.List;

public interface AppointmentService {

    void createAppointment(AppointmentRequestDto appointmentRequest);
    AppointmentResponseDto getAppointmentById(Long id);
    List<AppointmentResponseDto> getAllAppointmentsByPatient(Long idPatient);
    List<AppointmentResponseDto> getAllAppointmentsByDoctor(Long idDoctor);

}
