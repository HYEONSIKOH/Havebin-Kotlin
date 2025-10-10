package com.project.havebin.application.service;

import com.project.havebin.user.application.UserService;
import com.project.havebin.user.application.port.in.command.CreateUser;
import com.project.havebin.user.application.port.in.response.RegisterUserResponse;
import com.project.havebin.user.application.port.out.UserRepositoryPort;
import com.project.havebin.user.domain.entity.User;
import com.project.havebin.user.domain.vo.Email;
import com.project.havebin.user.domain.vo.Nickname;
import com.project.havebin.user.domain.vo.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("UserService 테스트")
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepositoryPort userRepositoryPort;

    @DisplayName("유저생성(회원가입)")
    @Test
    public void createUser() {
        // given
        CreateUser command = CreateUser.builder()
                .email(new Email("test123@test.com"))
                .password(new Password("test123!"))
                .nickname(new Nickname("test01"))
                .build();

        User savedUser = new User();
        when(userRepositoryPort.save(any(User.class))).thenReturn(savedUser);

        // when
        RegisterUserResponse response = userService.createUser(command);

        // then
        verify(userRepositoryPort, times(1)).save(any(User.class));
        assertThat(response).isNotNull();
    }

    @DisplayName("회원가입 실패")
    @Test
    void createUser_fail() {
        // given
        CreateUser command = CreateUser.builder()
                .email(new Email("fail@test.com"))
                .password(new Password("fail123!"))
                .nickname(new Nickname("failuser"))
                .build();

        // save가 null을 반환 → 예외 발생
        when(userRepositoryPort.save(any(User.class))).thenReturn(null);

        // when
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> userService.createUser(command))
                .isInstanceOf(RuntimeException.class);

        // then
        verify(userRepositoryPort, times(1)).save(any(User.class));
    }

    @DisplayName("회원가입 - 잘못된 이메일이면 예외, 저장 호출 안 함")
    @Test
    void createUser_invalidEmail() {
        // given
        CreateUser command = CreateUser.builder()
                .email(new Email("not-an-email"))
                .password(new Password("validPass123!"))
                .nickname(new Nickname("validNickname"))
                .build();

        // when & then
        assertThatThrownBy(() -> userService.createUser(command))
                .isInstanceOf(IllegalArgumentException.class);

        verify(userRepositoryPort, never()).save(any(User.class)); // userRepositoryPort.save()가 호출이 되었는지?
    }

    @DisplayName("회원가입 - 잘못된 닉네임이면 예외, 저장 호출 안 함")
    @Test
    void createUser_invalidNickname() {
        // given
        CreateUser command = CreateUser.builder()
                .email(new Email("test@example.com"))
                .password(new Password("validPass123!"))
                .nickname(new Nickname(" "))
                .build();

        // when & then
        assertThatThrownBy(() -> userService.createUser(command))
                .isInstanceOf(IllegalArgumentException.class);

        verify(userRepositoryPort, never()).save(any(User.class));
    }

    @DisplayName("회원가입 - 잘못된 비밀번호면 예외, 저장 호출 안 함")
    @Test
    void createUser_invalidPassword() {
        // given
        CreateUser command = CreateUser.builder()
                .email(new Email("test@example.com"))
                .password(new Password("va"))
                .nickname(new Nickname("validNickname"))
                .build();

        // when & then
        assertThatThrownBy(() -> userService.createUser(command))
                .isInstanceOf(IllegalArgumentException.class);

        verify(userRepositoryPort, never()).save(any(User.class));
    }
}
