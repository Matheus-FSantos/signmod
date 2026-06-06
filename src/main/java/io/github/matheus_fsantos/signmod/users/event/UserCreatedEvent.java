package io.github.matheus_fsantos.signmod.users.event;

public record UserCreatedEvent(
    String name,
    String email
) { }
