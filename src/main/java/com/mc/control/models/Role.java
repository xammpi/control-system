package com.mc.control.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, SUPPORT, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
