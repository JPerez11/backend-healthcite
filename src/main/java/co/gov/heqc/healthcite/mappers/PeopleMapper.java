package co.gov.heqc.healthcite.mappers;

import co.gov.heqc.healthcite.dto.request.PersonRequestDto;
import co.gov.heqc.healthcite.dto.response.PersonResponseDto;
import co.gov.heqc.healthcite.entities.PeopleEntity;

import java.util.List;

public interface PeopleMapper {

    PeopleEntity toPeopleEntity(PersonRequestDto personRequest);

    PersonResponseDto toPersonResponse(PeopleEntity peopleEntity);

    List<PersonResponseDto> toResponseList(List<PeopleEntity> peopleEntityList);

}
