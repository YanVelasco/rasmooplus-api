package com.yanvelasco.rasmooplus.model.services;

import com.yanvelasco.rasmooplus.model.dto.UserDTO;
import com.yanvelasco.rasmooplus.model.entities.UserEntity;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<UserEntity> createUser(UserDTO userDTO);
}
