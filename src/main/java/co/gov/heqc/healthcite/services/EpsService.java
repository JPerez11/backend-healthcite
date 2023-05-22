package co.gov.heqc.healthcite.services;

import co.gov.heqc.healthcite.dto.request.EpsRequestDto;
import co.gov.heqc.healthcite.dto.response.EpsResponseDto;

import java.util.List;

public interface EpsService {

    void createEps(EpsRequestDto epsRequest);
    EpsResponseDto getEpsById(Long id);
    EpsResponseDto getEpsByNit(String nit);
    List<EpsResponseDto> getAllEps();


}
