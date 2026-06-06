package io.github.matheus_fsantos.signmod.users.application.core.usecase;

import io.github.matheus_fsantos.signmod.users.application.core.domain.CreateUser;
import io.github.matheus_fsantos.signmod.users.application.core.utils.PasswordEncryptor;
import io.github.matheus_fsantos.signmod.users.application.ports.in.CreateUserInputPort;
import io.github.matheus_fsantos.signmod.users.application.ports.out.NotifyPublisherOutputPort;
import io.github.matheus_fsantos.signmod.users.application.ports.out.PersistUserOutputPort;

public class CreateUserUseCase implements CreateUserInputPort {
    private final PersistUserOutputPort persistUserOutputPort;
    private final NotifyPublisherOutputPort notifyPublisherOutputPort;

    public CreateUserUseCase(PersistUserOutputPort persistUserOutputPort, NotifyPublisherOutputPort notifyPublisherOutputPort) {
        this.persistUserOutputPort = persistUserOutputPort;
        this.notifyPublisherOutputPort = notifyPublisherOutputPort;
    }

    @Override
    public void create(CreateUser user) {
        CreateUser toSave = new CreateUser(user.name(), user.email(), PasswordEncryptor.encrypt(user.password()));
        this.persistUserOutputPort.persist(toSave);
        this.notifyPublisherOutputPort.publish(toSave);
    }
}
