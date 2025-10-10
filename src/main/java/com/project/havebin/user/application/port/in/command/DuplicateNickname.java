package com.project.havebin.user.application.port.in.command;

import com.project.havebin.user.domain.vo.Nickname;
import lombok.Builder;

@Builder
public record DuplicateNickname(Nickname nickname) {
}
