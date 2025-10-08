package com.project.havebin.user.adapter.in.web.dto.request;

import com.project.havebin.user.application.port.in.command.CreateUser;
import com.project.havebin.user.domain.vo.Email;
import com.project.havebin.user.domain.vo.Nickname;
import com.project.havebin.user.domain.vo.Password;

public record UserSignReqDto(String email, String password, String nickname) {
    public CreateUser toCommand() {
        return new CreateUser(
                new Email(email), new Password(password), new Nickname(nickname)
        );
    }
}
