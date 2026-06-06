package io.github.matheus_fsantos.signmod.notification.application.ports.out;

import io.github.matheus_fsantos.signmod.notification.application.core.domain.Email;

public interface PublishEmailOutputPort {
    void publish(Email email);
}
