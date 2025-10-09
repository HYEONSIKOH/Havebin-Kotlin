package com.project.havebin.user.adapter.out.persistence.mapper;

import com.project.havebin.user.adapter.out.persistence.entity.UserJpaEntity;
import com.project.havebin.user.domain.entity.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserMapper {
    // 도메인 → JPA (신규 생성용)
    public static UserJpaEntity toJpa(User domain) {
        return UserJpaEntity.builder()
                .externalId(domain.getId())
                .email(domain.getEmail())
                .nickname(domain.getNickname())
                .password(domain.getPassword())
                .profileImagePath(domain.getProfileImagePath())
                .roleType(domain.getRoleType())
                .build();
    }

    // JPA → 도메인 (복원용)
    public static User toDomain(UserJpaEntity e) {
        return new User(
                e.getExternalId(),
                e.getEmail(),
                e.getNickname(),
                e.getPassword(),
                e.getProfileImagePath(),
                e.getRoleType()
        );
    }
}
