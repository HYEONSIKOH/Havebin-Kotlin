package com.project.havebin.user.application.port.in.command;

import com.project.havebin.user.domain.vo.Email;
import com.project.havebin.user.domain.vo.Nickname;
import com.project.havebin.user.domain.vo.Password;

public record CreateUser(
        Email email,
        Password password,
        Nickname nickname) {
}

/**
 * Command는 도메인에 가까운 계층이기 때문
 * 	•	Command는 Application Layer에 속하지만,
 * 	    도메인의 유스케이스를 정확하게 모델링하기 위해 존재.
 * 	•	그러므로 **String보다 의미 있는 타입(VO)**를 쓰는 게 더 도메인 친화적.
 */
