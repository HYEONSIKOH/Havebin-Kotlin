package com.project.havebin.mail.adapter.in.web.dto;

import com.project.havebin.mail.adapter.in.web.dto.request.DuplicateMailReqDto;
import com.project.havebin.mail.adapter.in.web.dto.request.EmailAuthReqDto;
import com.project.havebin.mail.application.MailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@Tag(name = "Mail API", description = "메일 전송 및 인증 관련 API")
public class MailController {
    private final MailService mailService;

    @PostMapping("/validateDuplicateUser")
    public ResponseEntity<?> duplicateMail(@Valid @RequestBody DuplicateMailReqDto dto) {
        mailService.duplicateMail(dto.toCommand());
        return ResponseEntity.ok("success");
    }

    @PostMapping("/mailAuth")
    public ResponseEntity<?> mailCodeAuth(@Valid @RequestBody EmailAuthReqDto dto) {
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
