package org.havebin.havebin_kotlin.domain.user.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import org.havebin.havebin_kotlin.domain.user.entity.User
import org.havebin.havebin_kotlin.global.comm.enums.RoleType
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


class UserDto private constructor(){

    // 회원가입 요청 DTO
    data class SignUpReq (
        @NotBlank(message = "이메일은 필수 입력 항목입니다.")
        @Schema(description = "사용자 ID", example = "customer@test.com")
        val email: String,

        @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
        @Schema(description = "비밀번호", example = "123")
        val password: String,

        @NotBlank(message = "이름(별명)은 필수 입력 항목입니다.")
        @Schema(description = "이름(별명)", example = "통장잔고0원")
        val nickname: String
    ) {
        fun toEntity(passwordEncoder: BCryptPasswordEncoder): User {
            return User( 0L, email, passwordEncoder.encode(password), nickname, null, null, RoleType.USER )
        }
    }
}