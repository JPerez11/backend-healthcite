package co.gov.heqc.healthcite.mappers;

import co.gov.heqc.healthcite.dto.request.PersonRequestDto;
import co.gov.heqc.healthcite.dto.response.PersonResponseDto;
import co.gov.heqc.healthcite.entities.PeopleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PeopleMapper {

    @Mapping(target = "role.id", source = "idRole")
    PeopleEntity toPeopleEntity(PersonRequestDto personRequest);

    @Mapping(target = "roleName", source = "role.name")
    PersonResponseDto toPersonResponse(PeopleEntity peopleEntity);

    List<PersonResponseDto> toResponseList(List<PeopleEntity> peopleEntityList);

}
