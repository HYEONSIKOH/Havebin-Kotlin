package com.project.havebin.user.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ProfileImagePath {
    @Column(name = "profile_imgpath", unique = true, nullable = true)
    private String value;

    public ProfileImagePath() {
        this.value = null;
    }

    public ProfileImagePath(String value) {
        this.value = value;
    }
}
