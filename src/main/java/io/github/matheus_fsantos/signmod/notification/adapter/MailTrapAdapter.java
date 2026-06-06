package io.github.matheus_fsantos.signmod.notification.adapter;

import io.github.matheus_fsantos.signmod.notification.application.core.domain.Email;
import io.github.matheus_fsantos.signmod.notification.application.ports.out.PublishEmailOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class MailTrapAdapter implements PublishEmailOutputPort {
    private final JavaMailSender sender;

    @Override
    public void publish(Email email) {
        log.info("{} - publish - message: initiating communication with SMTP server", getClass().getSimpleName());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("peoples.signmod.staff@gmail.com");
            message.setTo(email.to());
            message.setSubject(email.subject());
            message.setText(email.body());

            this.sender.send(message);

            log.info("{} - publish - message: e-mail sent via SMTP successfully!", getClass().getSimpleName());
        } catch (Exception e) {
            log.error("{} - publish - message: error to send welcome e-mail, exception.message: {}", getClass().getSimpleName(), e.getMessage());
            e.printStackTrace();
        }
    }
}
