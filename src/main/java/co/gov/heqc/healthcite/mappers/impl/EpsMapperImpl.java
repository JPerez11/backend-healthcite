package co.gov.heqc.healthcite.mappers.impl;

import co.gov.heqc.healthcite.dto.request.EpsRequestDto;
import co.gov.heqc.healthcite.dto.response.EpsResponseDto;
import co.gov.heqc.healthcite.entities.EpsEntity;
import co.gov.heqc.healthcite.mappers.EpsMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class EpsMapperImpl implements EpsMapper {

    @Override
    public EpsEntity toEpsEntity(EpsRequestDto epsRequest) {

        if (epsRequest == null) {
            return null;
        }

        EpsEntity entity = new EpsEntity();
        entity.setName( epsRequest.getName() );
        entity.setNit( epsRequest.getNit() );
        entity.setFoundationDate( epsRequest.getFoundationDate() );
        entity.setAddress( epsRequest.getAddress() );
        entity.setPhone( epsRequest.getPhone() );

        return entity;
    }

    @Override
    public EpsResponseDto toEpsResponse(EpsEntity epsEntity) {

        if (epsEntity == null) {
            return null;
        }

        EpsResponseDto response = new EpsResponseDto();
        response.setName( epsEntity.getName() );
        response.setNit( epsEntity.getNit() );
        response.setFoundationDate( epsEntity.getFoundationDate() );
        response.setAddress( epsEntity.getAddress() );
        response.setPhone( epsEntity.getPhone() );

        return response;
    }

    @Override
    public List<EpsResponseDto> toResponseList(List<EpsEntity> epsEntityList) {

        if (epsEntityList == null || epsEntityList.isEmpty()) {
            return Collections.emptyList();
        }

        List<EpsResponseDto> list = new ArrayList<>(epsEntityList.size());

        for (EpsEntity eps :
                epsEntityList) {
            list.add(toEpsResponse(eps) );
        }

        return list;
    }
}
