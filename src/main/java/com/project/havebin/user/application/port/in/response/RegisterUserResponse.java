package com.project.havebin.user.application.port.in.response;

import lombok.Getter;

@Getter
public class RegisterUserResponse {
    private final String message;

    public RegisterUserResponse() {
        this.message = "Registration successful";
    }
}
