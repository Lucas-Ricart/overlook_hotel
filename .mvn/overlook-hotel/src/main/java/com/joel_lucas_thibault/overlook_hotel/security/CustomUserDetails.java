package com.joel_lucas_thibault.overlook_hotel.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {
    private final Integer userId;
    private final String userType; // "CLIENT" ou "MANAGER"

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
                             Integer userId, String userType) {
        super(username, password, authorities);
        this.userId = userId;
        this.userType = userType;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserType() {
        return userType;
    }
}