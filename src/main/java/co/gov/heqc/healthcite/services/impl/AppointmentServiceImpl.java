package co.gov.heqc.healthcite.services.impl;

import co.gov.heqc.healthcite.dto.request.AppointmentRequestDto;
import co.gov.heqc.healthcite.dto.response.AppointmentResponseDto;
import co.gov.heqc.healthcite.entities.AppointmentEntity;
import co.gov.heqc.healthcite.entities.EpsEntity;
import co.gov.heqc.healthcite.entities.PeopleEntity;
import co.gov.heqc.healthcite.exceptions.AppointmentNoDataFoundException;
import co.gov.heqc.healthcite.exceptions.AppointmentNotFoundException;
import co.gov.heqc.healthcite.exceptions.EpsNotFoundException;
import co.gov.heqc.healthcite.exceptions.PersonNotFoundException;
import co.gov.heqc.healthcite.mappers.AppointmentMapper;
import co.gov.heqc.healthcite.repositories.AppointmentRepository;
import co.gov.heqc.healthcite.repositories.EpsRepository;
import co.gov.heqc.healthcite.repositories.PeopleRepository;
import co.gov.heqc.healthcite.services.AppointmentService;
import co.gov.heqc.healthcite.utils.constants.GlobalConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PeopleRepository peopleRepository;
    private final EpsRepository epsRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public void createAppointment(AppointmentRequestDto appointmentRequest) {
        if (appointmentRequest == null) {
            throw new NullPointerException();
        }

        PeopleEntity patient = peopleRepository.findByDocumentAndRoleName(appointmentRequest.getPatientDocument(),
                GlobalConstants.PATIENT_ROLE).orElseThrow(PersonNotFoundException::new);
        PeopleEntity doctor = peopleRepository.findByDocumentAndRoleName(appointmentRequest.getDoctorDocument(),
                GlobalConstants.DOCTOR_ROLE).orElseThrow(PersonNotFoundException::new);
        EpsEntity eps = epsRepository.findByNameIgnoreCase(appointmentRequest.getEpsName())
                .orElseThrow(EpsNotFoundException::new);

        AppointmentEntity appointment = appointmentMapper.toAppointmentEntity(appointmentRequest);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setEps(eps);

        appointmentRepository.save(appointment);

    }

    @Override
    public AppointmentResponseDto getAppointmentById(Long id) {
        if (id == null) {
            throw new NullPointerException();
        }
        return appointmentMapper.toAppointmentResponse(appointmentRepository
                .findById(id)
                .orElseThrow(AppointmentNotFoundException::new));
    }

    @Override
    public List<AppointmentResponseDto> getAllAppointmentsByPatient(Long idPatient) {

        if (idPatient == null) {
            throw new NullPointerException();
        }
        List<AppointmentResponseDto> responseList = appointmentMapper.toResponseList(appointmentRepository
                .findAppointmentEntitiesByPatientId(idPatient));

        if (responseList.isEmpty()) {
            throw new AppointmentNoDataFoundException();
        }

        return responseList;
    }

    @Override
    public List<AppointmentResponseDto> getAllAppointmentsByDoctor(Long idDoctor) {

        if (idDoctor == null) {
            throw new NullPointerException();
        }
        List<AppointmentResponseDto> responseList = appointmentMapper.toResponseList(appointmentRepository
                .findAppointmentEntitiesByDoctorId(idDoctor));

        if (responseList.isEmpty()) {
            throw new AppointmentNoDataFoundException();
        }

        return responseList;
    }
}
