package com.lnu.bd.authentication;

public enum AuthenticationResult {
    SUCCESS("success"),
    INVALID_NAME("User with such login already exist"),
    INVALID_PASSWORD("Weak password"),
    INVALID_EMAIL("Invalid e-mail");

    private final String value;

    private AuthenticationResult(String s) {
        value = s;
    }

    public String getValue() {
        return value;
    }
}
