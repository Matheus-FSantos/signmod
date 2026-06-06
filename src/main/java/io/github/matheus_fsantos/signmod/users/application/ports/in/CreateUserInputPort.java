package io.github.matheus_fsantos.signmod.users.application.ports.in;

import io.github.matheus_fsantos.signmod.users.application.core.domain.CreateUser;

public interface CreateUserInputPort {
    void create(CreateUser user);
}
