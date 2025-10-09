package com.project.havebin.user.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Embeddable
@EqualsAndHashCode(of = "value")
public class Nickname {
    @Column(name = "nickname", unique = true, nullable = false)
    private String value;

    public Nickname() {
        throw new IllegalArgumentException("Nickname blank");
    }

    public Nickname(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Nickname blank");
        }

        if (value.length() < 2 || value.length() > 10) {
            throw new IllegalArgumentException("Invalid email format");
        }

        this.value = value;
    }
}
