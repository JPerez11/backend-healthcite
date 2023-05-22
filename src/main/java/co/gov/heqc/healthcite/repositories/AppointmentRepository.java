package co.gov.heqc.healthcite.repositories;

import co.gov.heqc.healthcite.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    List<AppointmentEntity> findAppointmentEntitiesByPatientId(Long id);
    List<AppointmentEntity> findAppointmentEntitiesByDoctorId(Long id);
}
