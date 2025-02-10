package org.havebin.havebin_kotlin.global.config

import org.springframework.context.annotation.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class SecurityConfig {
    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder() // 🔒 Spring이 관리하는 Bean 등록
    }
}