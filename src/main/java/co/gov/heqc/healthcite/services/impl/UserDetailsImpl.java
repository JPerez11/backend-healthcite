package co.gov.heqc.healthcite.services.impl;


import co.gov.heqc.healthcite.entities.PeopleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Class to implement a UserDetails and set the user from database.
 */
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final PeopleEntity peopleEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = peopleEntity.getRole().getName();
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return peopleEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return peopleEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return peopleEntity.getId();
    }
}