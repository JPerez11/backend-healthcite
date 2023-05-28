package co.gov.heqc.healthcite.repositories;

import co.gov.heqc.healthcite.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    List<AppointmentEntity> findAppointmentEntitiesByPatientId(Long id);
    List<AppointmentEntity> findAppointmentEntitiesByDoctorId(Long id);
    List<AppointmentEntity> findAppointmentEntitiesByDoctorIdAndStatus(Long id, String status);
    // Método para actualizar el estado de una cita por su ID
    @Modifying
    @Query("UPDATE AppointmentEntity a SET a.status = :newStatus WHERE a.id = :id")
    void updateStatusById(@Param("id") Long id, @Param("newStatus") String status);
    boolean existsByCitationDateAndDoctorId(LocalDateTime citationDate, Long id);
}
