package io.github.matheus_fsantos.signmod.notification.application.ports.in;

import io.github.matheus_fsantos.signmod.users.event.UserCreatedEvent;

public interface SendEmailInputPort {
    void send(UserCreatedEvent event);
}
