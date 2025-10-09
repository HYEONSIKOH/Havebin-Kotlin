package com.project.havebin.user.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Getter
@Embeddable
@EqualsAndHashCode(of = "value")
public class UserNo {
    @Column(name = "external_id", unique = true, nullable = true)
    private String value;

    public UserNo() {
        this.value = UUID.randomUUID().toString();
    }

    public UserNo(String value) {
        if (value == null || value.isBlank()) {
            value = UUID.randomUUID().toString();
        }

        this.value = value;
    }
}
