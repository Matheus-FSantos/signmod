package io.github.matheus_fsantos.signmod.users.adapter.in.http.request;

public record CreateUserRequest(
    String name,
    String email,
    String password
) { }
