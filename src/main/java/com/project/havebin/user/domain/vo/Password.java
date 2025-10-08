package com.project.havebin.user.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Password {
    @Column(name = "password", nullable = false)
    private String value;

    public Password() {
        throw new IllegalArgumentException("Password blank");
    }

    public Password(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Password blank");
        }

//        if (value.length() < 8 || value.length() > 20) {
//            throw new IllegalArgumentException("Password must be between 8 and 20 characters");
//        }

        this.value = value;
    }
}
