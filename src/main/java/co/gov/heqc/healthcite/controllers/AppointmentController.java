package co.gov.heqc.healthcite.controllers;

import co.gov.heqc.healthcite.dto.request.AppointmentRequestDto;
import co.gov.heqc.healthcite.dto.request.AppointmentStatusDto;
import co.gov.heqc.healthcite.dto.response.AppointPatientResponseDto;
import co.gov.heqc.healthcite.dto.response.AppointmentResponseDto;
import co.gov.heqc.healthcite.services.AppointmentService;
import co.gov.heqc.healthcite.utils.constants.AppointmentConstants;
import co.gov.heqc.healthcite.utils.constants.GlobalConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Secured({"DOCTOR", "PATIENT"})
    @PostMapping("/")
    public ResponseEntity<Map<String, String>> createAppointment(@Valid @RequestBody
                                                                     AppointmentRequestDto appointmentRequest) {
        appointmentService.createAppointment(appointmentRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Collections.singletonMap(
                        GlobalConstants.RESPONSE_MESSAGE_KEY,
                        AppointmentConstants.APPOINTMENT_CREATED_MESSAGE
                ));
    }

    @Secured({"DOCTOR"})
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDto> getAppointmentById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @Secured({"PATIENT"})
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<AppointPatientResponseDto>> getAllAppointmentsByPatientId(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAllAppointmentsByPatient(id));
    }

    @Secured({"DOCTOR"})
    @GetMapping("/doctor/{id}")
    public ResponseEntity<List<AppointmentResponseDto>> getAllAppointmentsByDoctorId(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAllAppointmentsByDoctor(id));
    }

    @Secured({"DOCTOR"})
    @GetMapping("/doctor/status/{id}")
    public ResponseEntity<List<AppointmentResponseDto>> getAllAppointmentsByDoctorIdAndStatus(
            @PathVariable Long id,
            @RequestBody AppointmentStatusDto appointmentStatus) {
        return ResponseEntity.ok(appointmentService.getAllAppointmentsByDoctorAndStatus(id, appointmentStatus));
    }

    @Secured({"DOCTOR"})
    @PatchMapping("/update/status/{id}")
    public ResponseEntity<Map<String, String>> updateAppointmentStatus(
            @PathVariable Long id,
            @RequestBody AppointmentStatusDto updateStatus) {
        appointmentService.updateAppointmentStatus(id, updateStatus);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Collections.singletonMap(
                        GlobalConstants.RESPONSE_MESSAGE_KEY,
                        AppointmentConstants.APPOINTMENT_UPDATED_MESSAGE
                ));
    }

}
