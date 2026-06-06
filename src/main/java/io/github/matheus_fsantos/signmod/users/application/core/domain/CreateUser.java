package io.github.matheus_fsantos.signmod.users.application.core.domain;

public record CreateUser(
    String name,
    String email,
    String password
) { }
