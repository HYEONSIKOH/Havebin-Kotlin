package org.havebin.havebin_kotlin.domain.user.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.havebin.havebin_kotlin.domain.user.dto.UserDto
import org.havebin.havebin_kotlin.global.comm.enums.RoleType

@Entity
class User (
    @Id @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(unique = true)
    val email: String,

    @JsonIgnore
    val password: String,

    val nickname: String,

    @Column(name = "kakao_id")
    var kakaoId: Long?  = null,

    @Column(name = "profile_img_path")
    var profileImgPath: String? = null,

    @Enumerated(EnumType.STRING)
    val roleType: RoleType
)