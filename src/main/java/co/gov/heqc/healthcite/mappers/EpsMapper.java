package co.gov.heqc.healthcite.mappers;

import co.gov.heqc.healthcite.dto.request.EpsRequestDto;
import co.gov.heqc.healthcite.dto.response.EpsResponseDto;
import co.gov.heqc.healthcite.entities.EpsEntity;

import java.util.List;

public interface EpsMapper {

    EpsEntity toEpsEntity(EpsRequestDto epsRequest);
    EpsResponseDto toEpsResponse(EpsEntity epsEntity);
    List<EpsResponseDto> toResponseList(List<EpsEntity> epsEntityList);

}
