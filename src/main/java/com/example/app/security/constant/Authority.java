package com.example.app.security.constant;

public class Authority {
    public static final String[] STUDENT_AUTHORITIES = {"user:read"};
    public static final String[] PROFESSOR_AUTHORITIES = {"user:read", "user:update"};
    public static final String[] ADMIN_AUTHORITIES = {"user:read", "user:update", "user:create"};
    public static final String[] SUPER_ADMIN_AUTHORITIES = {"user:read", "user:update", "user:create", "user:delete"};
}
