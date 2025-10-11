package com.project.havebin.mail.application.port.out;

import com.project.havebin.user.domain.vo.Email;

public interface MailSenderPort {
    boolean sendMessage(Email email, String code);
}
