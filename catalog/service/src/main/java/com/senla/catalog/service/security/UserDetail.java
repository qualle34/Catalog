package com.senla.catalog.service.security;

import com.senla.catalog.entity.User;
import com.senla.catalog.entity.enums.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserDetail implements UserDetails {

    private User user;

    public UserDetail() {
    }

    public UserDetail(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();

        for (UserRole role : user.getRoleSet()) {
            roles.add(new SimpleGrantedAuthority(role.name()));
        }
        return roles;
    }

    public long getId(){
        return user.getId();
    }

    @Override
    public String getPassword() {
        return user.getCreds().getPassword();
    }

    @Override
    public String getUsername() {
        return user.getCreds().getLogin();
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
}