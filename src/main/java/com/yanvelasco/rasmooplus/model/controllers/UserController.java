package com.yanvelasco.rasmooplus.model.controllers;

import com.yanvelasco.rasmooplus.model.dto.UserDTO;
import com.yanvelasco.rasmooplus.model.entities.UserEntity;
import com.yanvelasco.rasmooplus.model.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "Endpoints for managing users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Operation(summary = "Create a new user", description = "Create a new user")
    public ResponseEntity<UserEntity> createUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

}
