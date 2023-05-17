package com.mc.control.models.technical_request;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,SUPPORT,ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
