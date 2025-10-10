package com.project.havebin.user.application.port.in.command;

import lombok.Builder;

@Builder
public record GetUserData(Long id) {
}
