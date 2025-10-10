package com.project.havebin.user.adapter.out.persistence;

import com.project.havebin.user.adapter.out.persistence.entity.UserJpaEntity;
import com.project.havebin.user.adapter.out.persistence.mapper.UserMapper;
import com.project.havebin.user.adapter.out.persistence.repository.UserCustomRepository;
import com.project.havebin.user.adapter.out.persistence.repository.UserRepository;
import com.project.havebin.user.application.port.out.UserRepositoryPort;
import com.project.havebin.user.domain.entity.User;
import com.project.havebin.user.domain.vo.Nickname;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.Implementation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserJpaRepositoryAdapter implements UserRepositoryPort {
    //private final UserRepository repository;
    private final UserCustomRepository repository;

    @Override
    public void save(User user) {
        UserJpaEntity userJpaEntity = UserMapper.toJpa(user);

        repository.save(userJpaEntity);

        List<UserJpaEntity> users= repository.findAll();
        for (UserJpaEntity u : users) {
            log.info(u.getId() + " " + u.getExternalId().getValue() + " " + u.getEmail().getValue() + " " + u.getPassword().getValue() + " " + u.getNickname().getValue());
        }
    }

    @Override
    public boolean duplicateNickname(Nickname nickname) {
        return repository.existsByUsername(nickname);
    }

    @Override
    public User getUserDataById(Long id) {
        Optional<UserJpaEntity> userJpaEntityOptional = repository.findById(id);

        return userJpaEntityOptional
                .map(entity -> UserMapper.toDomain(entity))
                .orElse(null);
    }
}
