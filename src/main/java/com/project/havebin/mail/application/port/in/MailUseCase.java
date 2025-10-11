package com.project.havebin.mail.application.port.in;

import com.project.havebin.mail.application.port.in.command.DuplicateMail;

public interface MailUseCase {
    void duplicateMail(DuplicateMail command);
}
