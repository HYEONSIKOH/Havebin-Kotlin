package com.project.havebin.user.adapter.in.web.dto.request;

import com.project.havebin.user.application.port.in.command.DuplicateNickname;
import com.project.havebin.user.domain.vo.Nickname;

public record DuplicateNicknameReqDto(String nickname) {
    public DuplicateNickname toCommand() {
        return new DuplicateNickname(new Nickname(nickname));
    }
}
