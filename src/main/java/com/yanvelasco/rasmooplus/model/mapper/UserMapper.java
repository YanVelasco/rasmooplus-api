package com.yanvelasco.rasmooplus.model.mapper;

import com.yanvelasco.rasmooplus.model.dto.UserDTO;
import com.yanvelasco.rasmooplus.model.entities.SubscriptionTypeEntity;
import com.yanvelasco.rasmooplus.model.entities.UserEntity;
import com.yanvelasco.rasmooplus.model.entities.UserTypeEntity;

public class UserMapper {
    public static UserEntity toEntity(UserDTO userDTO, UserTypeEntity userTypeEntity, SubscriptionTypeEntity subscriptionTypeEntity) {
        return UserEntity.builder()
                .name(userDTO.name())
                .email(userDTO.email())
                .phone(userDTO.phone())
                .cpf(userDTO.cpf())
                .dtSubscription(userDTO.dtSubscription())
                .dtExpiration(userDTO.dtExpiration())
                .userType(userTypeEntity)
                .subscriptionType(subscriptionTypeEntity)
                .build();
    }

    public static UserDTO toDTO(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPhone(),
                userEntity.getCpf(),
                userEntity.getDtSubscription(),
                userEntity.getDtExpiration(),
                userEntity.getUserType().getId(),
                userEntity.getSubscriptionType() != null ? userEntity.getSubscriptionType().getId() : null
        );
    }

}