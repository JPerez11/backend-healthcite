package co.gov.heqc.healthcite.mappers.impl;

import co.gov.heqc.healthcite.dto.request.PersonRequestDto;
import co.gov.heqc.healthcite.dto.response.PersonResponseDto;
import co.gov.heqc.healthcite.entities.PeopleEntity;
import co.gov.heqc.healthcite.entities.RoleEntity;
import co.gov.heqc.healthcite.mappers.PeopleMapper;

import java.util.ArrayList;
import java.util.Collections;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeopleMapperImpl implements PeopleMapper {

    @Override
    public PeopleEntity toPeopleEntity(PersonRequestDto personRequest) {

        if (personRequest == null) {
            return null;
        }

        PeopleEntity peopleEntity = new PeopleEntity();
        peopleEntity.setFirstName( personRequest.getFirstName() );
        peopleEntity.setLastName( personRequest.getLastName() );
        peopleEntity.setDocument( personRequest.getDocument() );
        peopleEntity.setPhone( personRequest.getPhone() );
        peopleEntity.setAddress( personRequest.getAddress() );
        peopleEntity.setBirthdate( personRequest.getBirthdate() );
        peopleEntity.setGender( personRequest.getGender() );
        peopleEntity.setEmail( personRequest.getEmail() );
        peopleEntity.setUsername( personRequest.getUsername() );
        peopleEntity.setPassword( personRequest.getPassword() );
        peopleEntity.setRole( personRequestDtoToRoleEntity(personRequest) );


        return peopleEntity;
    }

    @Override
    public PersonResponseDto toPersonResponse(PeopleEntity peopleEntity) {

        if (peopleEntity == null) {
            return null;
        }

        PersonResponseDto personResponse = new PersonResponseDto();

        personResponse.setFirstName( peopleEntity.getFirstName() );
        personResponse.setLastName( peopleEntity.getLastName() );
        personResponse.setDocument( peopleEntity.getDocument() );
        personResponse.setPhone( peopleEntity.getPhone() );
        personResponse.setAddress( peopleEntity.getAddress() );
        personResponse.setBirthdate( peopleEntity.getBirthdate() );
        personResponse.setGender( peopleEntity.getGender() );
        personResponse.setEmail( peopleEntity.getEmail() );
        personResponse.setUsername( peopleEntity.getUsername() );
        personResponse.setRoleName( peopleEntityToRoleName(peopleEntity) );

        return personResponse;
    }

    @Override
    public List<PersonResponseDto> toResponseList(List<PeopleEntity> peopleEntityList) {

        if (peopleEntityList == null || peopleEntityList.isEmpty()) {
            return Collections.emptyList();
        }

        List<PersonResponseDto> list = new ArrayList<>(peopleEntityList.size());

        for (PeopleEntity people :
                peopleEntityList) {
            list.add( toPersonResponse(people) );
        }


        return list;
    }

    protected RoleEntity personRequestDtoToRoleEntity(PersonRequestDto personRequestDto) {

        if (personRequestDto == null) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(personRequestDto.getIdRole() );

        return roleEntity;
    }

    protected String peopleEntityToRoleName(PeopleEntity peopleEntity) {

        if ( peopleEntity == null ) {
            return null;
        }
        RoleEntity roleEntity = peopleEntity.getRole();
        if ( roleEntity == null ) {
            return null;
        }
        return roleEntity.getName();
    }

}

