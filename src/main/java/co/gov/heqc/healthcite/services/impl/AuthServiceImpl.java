package co.gov.heqc.healthcite.services.impl;

import co.gov.heqc.healthcite.configuration.security.jwt.JwtToken;
import co.gov.heqc.healthcite.dto.request.LoginRequestDto;
import co.gov.heqc.healthcite.dto.response.JwtResponseDto;
import co.gov.heqc.healthcite.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;

    @Override
    public JwtResponseDto login(LoginRequestDto loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwt = JwtToken.generateToken(userDetails);
        return new JwtResponseDto(jwt);
    }

}
