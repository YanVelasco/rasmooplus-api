package com.yanvelasco.rasmooplus.model.mapper;

import com.yanvelasco.rasmooplus.model.dto.SubscriptionTypeDTO;
import com.yanvelasco.rasmooplus.model.dto.SubscriptionTypeUpdateDTO;
import com.yanvelasco.rasmooplus.model.entities.SubscriptionTypeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubscriptionTypeMapper {

    public static SubscriptionTypeEntity toEntity(SubscriptionTypeDTO subscriptionTypeDTO) {
        return SubscriptionTypeEntity.builder()
                .name(subscriptionTypeDTO.name())
                .accessMonths(subscriptionTypeDTO.accessMonths())
                .price(subscriptionTypeDTO.price())
                .productKey(subscriptionTypeDTO.productKey())
                .build();
    }

    public static SubscriptionTypeEntity toEntity(SubscriptionTypeUpdateDTO subscriptionTypeUpdateDTO,
                                                  SubscriptionTypeEntity existingEntity) {
        return SubscriptionTypeEntity.builder()
                .id(existingEntity.getId())
                .name(subscriptionTypeUpdateDTO.name() != null ? subscriptionTypeUpdateDTO.name() :
                        existingEntity.getName())
                .accessMonths(subscriptionTypeUpdateDTO.accessMonths() != null ?
                        subscriptionTypeUpdateDTO.accessMonths() : existingEntity.getAccessMonths())
                .price(subscriptionTypeUpdateDTO.price() != null ? subscriptionTypeUpdateDTO.price() :
                        existingEntity.getPrice())
                .productKey(subscriptionTypeUpdateDTO.productKey() != null ? subscriptionTypeUpdateDTO.productKey() :
                        existingEntity.getProductKey())
                .build();
    }

    public static SubscriptionTypeDTO toDto(SubscriptionTypeEntity subscriptionType) {
        return SubscriptionTypeDTO.builder()
                .id(subscriptionType.getId())
                .name(subscriptionType.getName())
                .accessMonths(subscriptionType.getAccessMonths())
                .price(subscriptionType.getPrice())
                .productKey(subscriptionType.getProductKey())
                .build();
    }

    public static List<SubscriptionTypeDTO> toDto(List<SubscriptionTypeEntity> subscriptionTypeEntities) {
        return subscriptionTypeEntities.stream()
                .map(SubscriptionTypeMapper::toDto)
                .toList();
    }
}