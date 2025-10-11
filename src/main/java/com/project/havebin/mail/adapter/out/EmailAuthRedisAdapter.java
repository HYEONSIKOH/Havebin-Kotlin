package com.project.havebin.mail.adapter.out;

import com.project.havebin.mail.application.port.out.EmailAuthPort;
import com.project.havebin.user.domain.vo.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class EmailAuthRedisAdapter implements EmailAuthPort {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public void saveEmailAuthCode(Email email, String code) {
        redisTemplate.opsForValue().set(email.getValue(), code, 300, TimeUnit.SECONDS);
    }
}
