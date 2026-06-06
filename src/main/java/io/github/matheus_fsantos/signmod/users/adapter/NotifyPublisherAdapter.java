package io.github.matheus_fsantos.signmod.users.adapter;

import io.github.matheus_fsantos.signmod.users.event.UserCreatedEvent;
import io.github.matheus_fsantos.signmod.users.application.core.domain.CreateUser;
import io.github.matheus_fsantos.signmod.users.application.ports.out.NotifyPublisherOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotifyPublisherAdapter implements NotifyPublisherOutputPort {
    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(CreateUser user) {
        log.info("{} - notify - message: publishing a new notification event...", getClass().getSimpleName());

        UserCreatedEvent event = new UserCreatedEvent(user.name(), user.email());
        this.publisher.publishEvent(event);
    }
}
