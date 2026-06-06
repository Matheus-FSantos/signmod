package io.github.matheus_fsantos.signmod.users.adapter.in.http.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record HttpResponse(
    String message,
    HttpStatus status,
    LocalDateTime timestamp
) { }
