package com.project.havebin.user.application.port.in;

import com.project.havebin.user.application.port.in.command.CreateUser;
import com.project.havebin.user.application.port.in.response.RegisterUserResponse;

public interface UserUseCase {
    RegisterUserResponse createUser(CreateUser command);
}
