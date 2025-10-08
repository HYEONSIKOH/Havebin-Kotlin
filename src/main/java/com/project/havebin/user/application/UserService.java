package com.project.havebin.user.application;

import com.project.havebin.user.application.port.in.UserUseCase;
import com.project.havebin.user.application.port.in.command.CreateUser;
import com.project.havebin.user.application.port.in.response.RegisterUserResponse;
import com.project.havebin.user.domain.entity.User;
import com.project.havebin.user.domain.vo.Password;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    @Override
    public RegisterUserResponse createUser(CreateUser command) {
        User user = new User();
        user.create(
                command.email(),
                command.nickname(),
                command.password()
        );

        return new RegisterUserResponse();
    }
}
