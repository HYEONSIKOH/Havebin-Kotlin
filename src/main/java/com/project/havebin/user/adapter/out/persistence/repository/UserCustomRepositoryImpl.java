package com.project.havebin.user.adapter.out.persistence.repository;

import com.project.havebin.user.adapter.out.persistence.entity.UserJpaEntity;
import com.project.havebin.user.domain.vo.Nickname;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {
    private static final List<UserJpaEntity> userTable = new ArrayList<>();

    @Override
    public List<UserJpaEntity> findAll() {
        return userTable;
    }

    @Override
    public UserJpaEntity save(UserJpaEntity userJpaEntity) {
        if (userJpaEntity.getId() == null) {
            Long newId = (long) (userTable.size() + 1);
            userJpaEntity.setPK(newId);
            userTable.add(userJpaEntity);

            return userJpaEntity;
        } else {
            for (int i = 0; i < userTable.size(); i++) {
                if (userTable.get(i).getId().equals(userJpaEntity.getId())) {
                    userTable.set(i, userJpaEntity);
                }
            }

            return userJpaEntity;
        }
    }

    @Override
    public boolean existsByUsername(Nickname nickname) {
        for (UserJpaEntity user : userTable) {
            if (user.getNickname().equals(nickname)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Optional<UserJpaEntity> findById(Long id) {
        for (UserJpaEntity user : userTable) {
            if (user.getId().equals(id))
                return Optional.of(user);
        }

        return Optional.empty();
    }

    @Override
    public boolean existsByEmail(String email) {
        for (UserJpaEntity user : userTable) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }

        return false;
    }
}
