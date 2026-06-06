package io.github.matheus_fsantos.signmod.notification.application.core.usecase;

import io.github.matheus_fsantos.signmod.notification.application.core.domain.Email;
import io.github.matheus_fsantos.signmod.notification.application.ports.in.SendEmailInputPort;
import io.github.matheus_fsantos.signmod.notification.application.ports.out.PublishEmailOutputPort;
import io.github.matheus_fsantos.signmod.users.event.UserCreatedEvent;

public class SendEmailUseCase implements SendEmailInputPort {
    private final PublishEmailOutputPort publishEmailOutputPort;

    public SendEmailUseCase(PublishEmailOutputPort publishEmailOutputPort) {
        this.publishEmailOutputPort = publishEmailOutputPort;
    }

    @Override
    public void send(UserCreatedEvent event) {
        String subject = String.format("Welcome, %s! 🚀", event.name());
        String body = """
            Hello, %s!

            Your account was created with absolute success and we are very happy to have you with us! 🎉
            From now on, you have full access to our platform. If you need any help or have any questions, just reply directly to this email and our team will be ready to support you.

            Get ready to build great things together!

            See you soon,
            SignMod Engineering Team 🛡️
        """;

        Email email = new Email(event.email(), subject, String.format(body, event.name()));
        this.publishEmailOutputPort.publish(email);
    }
}
