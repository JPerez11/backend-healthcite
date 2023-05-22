package co.gov.heqc.healthcite.controllers;

import co.gov.heqc.healthcite.dto.request.AppointmentRequestDto;
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
@CrossOrigin(origins = "http://127.0.0.1:5500")
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

    @Secured({"DOCTOR"})
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<AppointmentResponseDto>> getAllAppointmentsByPatientId(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAllAppointmentsByPatient(id));
    }

    @Secured({"DOCTOR"})
    @GetMapping("/doctor/{id}")
    public ResponseEntity<List<AppointmentResponseDto>> getAllAppointmentByDoctorId(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAllAppointmentsByDoctor(id));
    }


}
