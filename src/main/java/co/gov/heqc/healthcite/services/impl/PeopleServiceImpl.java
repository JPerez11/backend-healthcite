package co.gov.heqc.healthcite.services.impl;

import co.gov.heqc.healthcite.dto.request.PersonRequestDto;
import co.gov.heqc.healthcite.dto.response.PersonResponseDto;
import co.gov.heqc.healthcite.entities.PeopleEntity;
import co.gov.heqc.healthcite.exceptions.MailAlreadyExistsException;
import co.gov.heqc.healthcite.exceptions.PeopleNoDataFoundException;
import co.gov.heqc.healthcite.exceptions.PersonAlreadyExistsException;
import co.gov.heqc.healthcite.exceptions.PersonNotFoundException;
import co.gov.heqc.healthcite.mappers.PeopleMapper;
import co.gov.heqc.healthcite.repositories.PeopleRepository;
import co.gov.heqc.healthcite.services.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {

    private final PeopleRepository peopleRepository;
    private final PeopleMapper peopleMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createPerson(PersonRequestDto personRequest) {
        if (personRequest == null) {
            throw new NullPointerException();
        }
        if (peopleRepository.existsByDocument(personRequest.getDocument())) {
            throw new PersonAlreadyExistsException();
        }
        if (peopleRepository.existsByEmail(personRequest.getEmail())) {
            throw new MailAlreadyExistsException();
        }
        personRequest.setPassword( passwordEncoder.encode(personRequest.getPassword()) );
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

    @Override
    public List<PersonResponseDto> getAllPeopleByRole(String role) {
        List<PeopleEntity> peopleEntityList = peopleRepository.findAllByRoleName(role);
        if (peopleEntityList.isEmpty()) {
            throw new PeopleNoDataFoundException();
        }

        return peopleMapper.toResponseList(peopleEntityList);
    }
}
