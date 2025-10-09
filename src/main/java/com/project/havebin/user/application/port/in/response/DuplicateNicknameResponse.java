package com.project.havebin.user.application.port.in.response;

import lombok.Getter;

@Getter
public class DuplicateNicknameResponse {
    private final String message;

    public DuplicateNicknameResponse() {
        this.message = "Nickname Not Duplicate";
    }
}
