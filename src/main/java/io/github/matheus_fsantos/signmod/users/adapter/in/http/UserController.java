package io.github.matheus_fsantos.signmod.users.adapter.in.http;

import io.github.matheus_fsantos.signmod.users.adapter.in.http.mapper.CreateUserRequestMapper;
import io.github.matheus_fsantos.signmod.users.adapter.in.http.request.CreateUserRequest;
import io.github.matheus_fsantos.signmod.users.adapter.in.http.response.HttpResponse;
import io.github.matheus_fsantos.signmod.users.application.ports.in.CreateUserInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController {
    private final CreateUserInputPort createUserInputPort;

    @PostMapping
    @Transactional
    public ResponseEntity<HttpResponse> create(@RequestBody CreateUserRequest request) {
        log.info("{} - create - message: init workflow to save/create a new user in module, user.email: {} <---- HTTP/BEGIN (POST)", getClass().getSimpleName(), request.email());
        this.createUserInputPort.create(CreateUserRequestMapper.toDomain(request));

        log.info("{} - create - message: user created successfully, user.email: {} ----> HTTP/END (POST)", getClass().getSimpleName(), request.email());
        return ResponseEntity.status(HttpStatus.OK).body(new HttpResponse(String.format("user %s created successfully", request.email()), HttpStatus.CREATED, LocalDateTime.now()));
    }
}
