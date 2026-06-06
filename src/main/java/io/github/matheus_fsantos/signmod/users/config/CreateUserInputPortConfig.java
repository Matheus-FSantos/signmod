package io.github.matheus_fsantos.signmod.users.config;

import io.github.matheus_fsantos.signmod.users.application.core.usecase.CreateUserUseCase;
import io.github.matheus_fsantos.signmod.users.application.ports.in.CreateUserInputPort;
import io.github.matheus_fsantos.signmod.users.application.ports.out.NotifyPublisherOutputPort;
import io.github.matheus_fsantos.signmod.users.application.ports.out.PersistUserOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateUserInputPortConfig {
    @Bean
    public CreateUserInputPort createUserUseCaseConfig(PersistUserOutputPort persistUserOutputPort, NotifyPublisherOutputPort notifyPublisherOutputPort) {
        return new CreateUserUseCase(persistUserOutputPort, notifyPublisherOutputPort);
    }
}
