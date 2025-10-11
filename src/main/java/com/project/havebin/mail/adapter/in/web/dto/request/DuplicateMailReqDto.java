package com.project.havebin.mail.adapter.in.web.dto.request;

import com.project.havebin.mail.application.port.in.command.DuplicateMail;
import com.project.havebin.user.domain.vo.Email;

public record DuplicateMailReqDto(String email) {
    public DuplicateMail toCommand() {
        return new DuplicateMail(new Email(email));
    }
}
