package io.github.matheus_fsantos.signmod.notification.application.core.domain;

public record Email(
    String to,
    String subject,
    String body
) { }
