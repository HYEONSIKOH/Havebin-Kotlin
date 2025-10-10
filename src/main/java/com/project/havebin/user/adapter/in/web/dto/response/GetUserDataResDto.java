package com.project.havebin.user.adapter.in.web.dto.response;

public record GetUserDataResDto(
        String email,
        String nickname,
        String profileImgPath,
        String roleType
) {

}
