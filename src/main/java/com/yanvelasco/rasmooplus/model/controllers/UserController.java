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

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

}
