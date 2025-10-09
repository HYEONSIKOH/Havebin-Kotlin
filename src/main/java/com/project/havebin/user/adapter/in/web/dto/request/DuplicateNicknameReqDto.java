package com.project.havebin.user.adapter.in.web.dto.request;

import com.project.havebin.user.application.port.in.command.CreateUser;
import com.project.havebin.user.application.port.in.command.DuplicateNickname;
import com.project.havebin.user.domain.vo.Email;
import com.project.havebin.user.domain.vo.Nickname;
import com.project.havebin.user.domain.vo.Password;

public record DuplicateNicknameReqDto(String nickname) {
    public DuplicateNickname toCommand() {
        return new DuplicateNickname(new Nickname(nickname));
    }
}
