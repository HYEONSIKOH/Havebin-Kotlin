package com.project.havebin.user.adapter.out.persistence.repository;

import com.project.havebin.user.adapter.out.persistence.entity.UserJpaEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

public interface UserCustomRepository {
    void save(UserJpaEntity userJpaEntity);

    List<UserJpaEntity> findAll();
}
