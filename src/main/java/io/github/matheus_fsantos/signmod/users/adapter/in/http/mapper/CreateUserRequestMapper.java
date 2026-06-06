package io.github.matheus_fsantos.signmod.users.adapter.in.http.mapper;

import io.github.matheus_fsantos.signmod.users.adapter.in.http.request.CreateUserRequest;
import io.github.matheus_fsantos.signmod.users.application.core.domain.CreateUser;

public class CreateUserRequestMapper {
    private CreateUserRequestMapper() { }

    public static CreateUser toDomain(CreateUserRequest request) {
        return new CreateUser(request.name(), request.email(), request.password());
    }
}
