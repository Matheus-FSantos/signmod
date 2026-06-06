package io.github.matheus_fsantos.signmod.users.adapter.out.repository;

import io.github.matheus_fsantos.signmod.users.adapter.out.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface UserRepository extends JpaRepository<UserEntity, UUID> { }
