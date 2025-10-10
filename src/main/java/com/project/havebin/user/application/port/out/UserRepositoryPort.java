package com.project.havebin.user.application.port.out;

import com.project.havebin.user.adapter.out.persistence.entity.UserJpaEntity;
import com.project.havebin.user.domain.entity.User;
import com.project.havebin.user.domain.vo.Nickname;

public interface UserRepositoryPort {
    User save(User user);

    boolean duplicateNickname(Nickname nickname);

    User getUserDataById(Long id);
}
