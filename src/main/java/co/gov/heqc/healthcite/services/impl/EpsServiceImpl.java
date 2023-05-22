package co.gov.heqc.healthcite.services.impl;

import co.gov.heqc.healthcite.dto.request.EpsRequestDto;
import co.gov.heqc.healthcite.dto.response.EpsResponseDto;
import co.gov.heqc.healthcite.exceptions.EpsAlreadyExistsException;
import co.gov.heqc.healthcite.exceptions.EpsNoDataFoundException;
import co.gov.heqc.healthcite.exceptions.EpsNotFoundException;
import co.gov.heqc.healthcite.exceptions.EpsNotFoundByNitException;
import co.gov.heqc.healthcite.mappers.EpsMapper;
import co.gov.heqc.healthcite.repositories.EpsRepository;
import co.gov.heqc.healthcite.services.EpsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EpsServiceImpl implements EpsService {

    private final EpsRepository epsRepository;
    private final EpsMapper epsMapper;

    @Override
    public void createEps(EpsRequestDto epsRequest) {
        if (epsRequest == null) {
            throw new NullPointerException();
        }

        if (epsRepository.existsByNit(epsRequest.getNit())) {
            throw new EpsAlreadyExistsException();
        }

        epsRepository.save(epsMapper.toEpsEntity(epsRequest));

    }

    @Override
    public EpsResponseDto getEpsById(Long id) {
        if (id == null) {
            throw new NullPointerException();
        }
        return epsMapper.toEpsResponse(epsRepository
                .findById(id)
                .orElseThrow(EpsNotFoundException::new));
    }

    @Override
    public EpsResponseDto getEpsByNit(String nit) {
        if (nit == null) {
            throw new NullPointerException();
        }
        return epsMapper.toEpsResponse(epsRepository
                .findByNit(nit)
                .orElseThrow(EpsNotFoundByNitException::new));
    }

    @Override
    public List<EpsResponseDto> getAllEps() {
        List<EpsResponseDto> responseList = epsMapper
                .toResponseList(epsRepository
                .findAll());

        if (responseList == null || responseList.isEmpty()) {
            throw new EpsNoDataFoundException();
        }

        return responseList;
    }
}
