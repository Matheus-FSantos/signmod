package io.github.matheus_fsantos.signmod.notification.adapter.in.event;

import io.github.matheus_fsantos.signmod.notification.application.ports.in.SendEmailInputPort;
import io.github.matheus_fsantos.signmod.users.event.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationEventListener {
    private final SendEmailInputPort sendEmailInputPort;

    @ApplicationModuleListener
    public void welcomeNotification(UserCreatedEvent event) {
        log.info("{} - welcomeNotification - message: notification event triggered, initiating automatic workflow.. user.email: {}", getClass().getSimpleName(), event.email());
        this.sendEmailInputPort.send(event);
    }
}
