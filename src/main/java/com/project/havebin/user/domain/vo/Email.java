package com.project.havebin.user.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Email {
    @Column(name = "email", unique = true, nullable = false)
    private String value;

    public Email() {
        throw new IllegalArgumentException("email blank");
    }

    public Email(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("email blank");
        }

        String v = value.trim();
        String REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!v.matches(REGEX)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        this.value = value;
    }
}
