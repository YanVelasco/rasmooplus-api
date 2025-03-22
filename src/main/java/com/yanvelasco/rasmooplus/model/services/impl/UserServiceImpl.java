package com.yanvelasco.rasmooplus.model.services.impl;

import com.yanvelasco.rasmooplus.exceptions.AlreadyExistsException;
import com.yanvelasco.rasmooplus.exceptions.ResourceNotFoundException;
import com.yanvelasco.rasmooplus.model.dto.UserDTO;
import com.yanvelasco.rasmooplus.model.entities.UserEntity;
import com.yanvelasco.rasmooplus.model.entities.UserTypeEntity;
import com.yanvelasco.rasmooplus.model.mapper.UserMapper;
import com.yanvelasco.rasmooplus.model.repositories.UserRepository;
import com.yanvelasco.rasmooplus.model.repositories.UserTypeRepository;
import com.yanvelasco.rasmooplus.model.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;

    public UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<UserEntity> createUser(UserDTO userDTO) {

        userRepository.findByEmail(userDTO.email()).ifPresent(user -> {
            throw new AlreadyExistsException("User already exists with this email");
        });

        var userType = userTypeRepository.findById(userDTO.userTypeId()).orElseThrow(
                () -> new ResourceNotFoundException("User type", "id", userDTO.userTypeId())
        );


        UserTypeEntity userTypeEntity = userType;

        var userEntity = UserMapper.toEntity(userDTO, userTypeEntity, null);

        userRepository.save(userEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body((userEntity));
    }

}