package co.gov.heqc.healthcite.services;

import co.gov.heqc.healthcite.dto.request.PersonRequestDto;
import co.gov.heqc.healthcite.dto.response.PersonResponseDto;

import java.util.List;

public interface PeopleService {

    void createPerson(PersonRequestDto personRequest);
    PersonResponseDto getPersonById(Long id);
    List<PersonResponseDto> getAllPeople();


}
