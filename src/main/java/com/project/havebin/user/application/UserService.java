package com.project.havebin.user.application;

import com.project.havebin.user.application.port.in.UserUseCase;
import com.project.havebin.user.application.port.in.command.CreateUser;
import com.project.havebin.user.application.port.in.command.DuplicateNickname;
import com.project.havebin.user.application.port.in.response.DuplicateNicknameResponse;
import com.project.havebin.user.application.port.in.response.RegisterUserResponse;
import com.project.havebin.user.application.port.out.UserRepositoryPort;
import com.project.havebin.user.domain.entity.User;
import com.project.havebin.user.domain.vo.Password;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public RegisterUserResponse createUser(CreateUser command) {
        User user = new User();
        user.create(
                command.email(),
                command.nickname(),
                command.password()
        );

        userRepositoryPort.save(user);

        return new RegisterUserResponse();
    }

    @Override
    public DuplicateNicknameResponse duplicateNickname(DuplicateNickname command) {
        if (userRepositoryPort.duplicateNickname(command.nickname())) {
            throw new RuntimeException("Nickname Duplicate");
        }

        return new DuplicateNicknameResponse();
    }
}
