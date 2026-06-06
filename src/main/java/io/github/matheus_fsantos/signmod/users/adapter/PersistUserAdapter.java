package io.github.matheus_fsantos.signmod.users.adapter;

import io.github.matheus_fsantos.signmod.users.adapter.out.repository.UserRepository;
import io.github.matheus_fsantos.signmod.users.adapter.out.repository.entity.UserEntity;
import io.github.matheus_fsantos.signmod.users.application.core.domain.CreateUser;
import io.github.matheus_fsantos.signmod.users.application.ports.out.PersistUserOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersistUserAdapter implements PersistUserOutputPort {
    private final UserRepository userRepository;

    @Override
    public void persist(CreateUser user) {
        log.info("{} - persist - message: saving user to in-memory database, date: {}", getClass().getSimpleName(), LocalDateTime.now());

        this.userRepository.save(
            UserEntity.builder()
                .name(user.name())
                .email(user.email())
                .password(user.password())
            .build()
        );
    }
}
