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
    public void save(UserJpaEntity userJpaEntity) {
        if (userJpaEntity.getId() == null) {
            Long newId = (long) (userTable.size() + 1);
            userJpaEntity.setPK(newId);
            userTable.add(userJpaEntity);
        } else {
            for (int i = 0; i < userTable.size(); i++) {
                if (userTable.get(i).getId().equals(userJpaEntity.getId())) {
                    userTable.set(i, userJpaEntity);
                    return;
                }
            }
            userTable.add(userJpaEntity);
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
}
