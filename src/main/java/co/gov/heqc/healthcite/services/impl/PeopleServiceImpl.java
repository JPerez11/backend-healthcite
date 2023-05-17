package co.gov.heqc.healthcite.services.impl;

import co.gov.heqc.healthcite.dto.request.PersonRequestDto;
import co.gov.heqc.healthcite.dto.response.PersonResponseDto;
import co.gov.heqc.healthcite.entities.PeopleEntity;
import co.gov.heqc.healthcite.exceptions.PeopleNoDataFoundException;
import co.gov.heqc.healthcite.exceptions.PersonNotFoundException;
import co.gov.heqc.healthcite.mappers.PeopleMapper;
import co.gov.heqc.healthcite.repositories.PeopleRepository;
import co.gov.heqc.healthcite.services.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {

    private final PeopleRepository peopleRepository;
    private final PeopleMapper peopleMapper;

    @Override
    public void createPerson(PersonRequestDto personRequest) {
        if (personRequest == null) {
            throw new NullPointerException();
        }
        peopleRepository.save(peopleMapper.toPeopleEntity(personRequest));
    }

    @Override
    public PersonResponseDto getPersonById(Long id) {
        return peopleMapper.toPersonResponse(peopleRepository
                .findById(id)
                .orElseThrow(PersonNotFoundException::new));
    }

    @Override
    public List<PersonResponseDto> getAllPeople() {
        List<PeopleEntity> peopleEntityList = peopleRepository.findAll();
        if (peopleEntityList.isEmpty()) {
            throw new PeopleNoDataFoundException();
        }

        return peopleMapper.toResponseList(peopleEntityList);
    }
}
