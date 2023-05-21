package co.gov.heqc.healthcite.services;

import co.gov.heqc.healthcite.dto.request.LoginRequestDto;
import co.gov.heqc.healthcite.dto.response.JwtResponseDto;

public interface AuthService {

    JwtResponseDto login(LoginRequestDto loginRequest);

}
