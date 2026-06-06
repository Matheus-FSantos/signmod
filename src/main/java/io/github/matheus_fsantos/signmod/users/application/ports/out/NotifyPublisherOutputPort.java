package io.github.matheus_fsantos.signmod.users.application.ports.out;

import io.github.matheus_fsantos.signmod.users.application.core.domain.CreateUser;

public interface NotifyPublisherOutputPort {
    void publish(CreateUser user);
}
