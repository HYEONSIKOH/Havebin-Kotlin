package com.project.havebin.user.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Embeddable
@Getter
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
