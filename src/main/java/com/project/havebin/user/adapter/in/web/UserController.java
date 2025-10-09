package com.project.havebin.user.adapter.in.web;

import com.project.havebin.user.adapter.in.web.dto.request.DuplicateNicknameReqDto;
import com.project.havebin.user.adapter.in.web.dto.request.UserSignReqDto;
import com.project.havebin.user.application.port.in.UserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@Tag(name = "User API", description = "유저 관련 API")
public class UserController {

    private final UserUseCase userUseCase;

    @PostMapping("/responseUserInfo")
    @Operation(summary = "회원가입")
    public ResponseEntity<?> responseUserInfo(@Valid @RequestBody UserSignReqDto reqDto) {
        return ResponseEntity.ok(userUseCase.createUser(reqDto.toCommand()));
    }

    @PostMapping("/validateDuplicateNickname")
    @Operation(summary = "닉네임 중복검사")
    public ResponseEntity<?> duplicateNickname(@Valid @RequestBody DuplicateNicknameReqDto reqDto) {
        return ResponseEntity.ok(userUseCase.duplicateNickname(reqDto.toCommand()));
    }

    @DeleteMapping("/deleteUser")
    @Operation(summary = "회원탈퇴")
    public ResponseEntity<?> deleteUser(/*@AuthenticationPrincipal Long id*/) {
        return ResponseEntity.ok("Not Implemented");
    }

    @GetMapping("/getUserdata")
    @Operation(summary = "유저 정보 조회")
    public ResponseEntity<?> getUserdata(/*@AuthenticationPrincipal Long id*/) {
        return ResponseEntity.ok("Not Implemented");
    }

    //===================== [예외 처리] =====================

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity
                .badRequest()
                .body(Map.of(
                        "message", ex.getMessage(),
                        "status", 400
                ));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity
                .badRequest()
                .body(Map.of(
                        "message", ex.getMessage(),
                        "status", 401
                ));
    }
}
