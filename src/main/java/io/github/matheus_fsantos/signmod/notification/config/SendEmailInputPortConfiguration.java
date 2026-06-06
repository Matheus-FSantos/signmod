package io.github.matheus_fsantos.signmod.notification.config;

import io.github.matheus_fsantos.signmod.notification.application.core.usecase.SendEmailUseCase;
import io.github.matheus_fsantos.signmod.notification.application.ports.in.SendEmailInputPort;
import io.github.matheus_fsantos.signmod.notification.application.ports.out.PublishEmailOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendEmailInputPortConfiguration {
    @Bean
    public SendEmailInputPort sendEmailUseCaseConfiguration(PublishEmailOutputPort publishEmailOutputPort) {
        return new SendEmailUseCase(publishEmailOutputPort);
    }
}
