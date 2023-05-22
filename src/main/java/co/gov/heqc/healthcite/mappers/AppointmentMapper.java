package co.gov.heqc.healthcite.mappers;

import co.gov.heqc.healthcite.dto.request.AppointmentRequestDto;
import co.gov.heqc.healthcite.dto.response.AppointmentResponseDto;
import co.gov.heqc.healthcite.entities.AppointmentEntity;

import java.util.List;

public interface AppointmentMapper {

    AppointmentEntity toAppointmentEntity(AppointmentRequestDto appointmentRequest);
    AppointmentResponseDto toAppointmentResponse(AppointmentEntity appointmentEntity);
    List<AppointmentResponseDto> toResponseList(List<AppointmentEntity> appointmentEntityList);

}
