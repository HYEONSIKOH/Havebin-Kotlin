package com.project.havebin.user.domain.entity;

import com.project.havebin.user.domain.enums.RoleType;
import com.project.havebin.user.domain.vo.*;
import lombok.Getter;

@Getter
public class User {
    private final UserNo id;
    private Email email;
    private Nickname nickname;
    private Password password;
    private ProfileImagePath profileImagePath;
    private final RoleType roleType;

    public User() {
        this.id = new UserNo();
        this.roleType = RoleType.USER;
        this.profileImagePath = new ProfileImagePath();
    }

    public User(RoleType roleType) {
        this.id = new UserNo();
        this.roleType = roleType;
        this.profileImagePath = new ProfileImagePath();
    }

    public User create(Email email, Nickname nickname, Password password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        return this;
    }
}
