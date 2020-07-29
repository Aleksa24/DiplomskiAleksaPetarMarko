package com.example.app.security.constant;


import static com.example.app.security.constant.Authority.*;

public enum Role {
    ROLE_STUDENT(STUDENT_AUTHORITIES),
    ROLE_PROFESSOR(PROFESSOR_AUTHORITIES),
    ROLE_ADMIN(ADMIN_AUTHORITIES),
    ROLE_SUPER_ADMIN(SUPER_ADMIN_AUTHORITIES);

    private final String[] authorities;

    Role(String... authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }

}
