package co.gov.heqc.healthcite.services.impl;

import co.gov.heqc.healthcite.entities.PeopleEntity;
import co.gov.heqc.healthcite.repositories.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        PeopleEntity peopleEntity = peopleRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("The user with email " + email + " doesn't exist."));
        return new UserDetailsImpl(peopleEntity);
    }
}
