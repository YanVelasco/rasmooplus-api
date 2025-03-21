package com.yanvelasco.rasmooplus.model.services.impl;

import com.yanvelasco.rasmooplus.exceptions.IsEmptyException;
import com.yanvelasco.rasmooplus.exceptions.ResourceNotFoundException;
import com.yanvelasco.rasmooplus.model.dto.SubscriptionTypeDTO;
import com.yanvelasco.rasmooplus.model.dto.SubscriptionTypeUpdateDTO;
import com.yanvelasco.rasmooplus.model.entities.SubscriptionTypeEntity;
import com.yanvelasco.rasmooplus.model.repositories.SubscriptionTypeRepository;
import com.yanvelasco.rasmooplus.model.services.SubscriptionTypeEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionTypeEntityServiceImpl implements SubscriptionTypeEntityService {

    private final SubscriptionTypeRepository subscriptionTypeRepository;

    public SubscriptionTypeEntityServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    @Override
    public ResponseEntity<List<SubscriptionTypeEntity>> findAll(){
        List<SubscriptionTypeEntity> list = subscriptionTypeRepository.findAll();
        if (list.isEmpty()) {
            throw new IsEmptyException("Has no subscriptions type registered");
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @Override
    public ResponseEntity<SubscriptionTypeEntity> findById(Long id){
        var subscriptionTypeEntity = subscriptionTypeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subscription type", "id", id)
        );
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeEntity);
    }

    @Override
    public ResponseEntity<SubscriptionTypeEntity> create(SubscriptionTypeDTO subscriptionTypeDTO) {
        var subscriptionTypeEntity = SubscriptionTypeEntity.builder()
                .name(subscriptionTypeDTO.name())
                .accessMonths(subscriptionTypeDTO.accessMonths())
                .price(subscriptionTypeDTO.price())
                .productKey(subscriptionTypeDTO.productKey())
                .build();

        subscriptionTypeRepository.save(subscriptionTypeEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionTypeEntity);
    }

   @Override
    public ResponseEntity<SubscriptionTypeEntity> update(Long id, SubscriptionTypeUpdateDTO subscriptionTypeUpdateDTO) {
        var subscribeEntity = subscriptionTypeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subscription type", "id", id)
        );
        var update = SubscriptionTypeEntity.builder()
                .id(subscribeEntity.getId())
                .name(subscriptionTypeUpdateDTO.name() != null ? subscriptionTypeUpdateDTO.name() : subscribeEntity.getName())
                .accessMonths(subscriptionTypeUpdateDTO.accessMonths() != null ? subscriptionTypeUpdateDTO.accessMonths() : subscribeEntity.getAccessMonths())
                .price(subscriptionTypeUpdateDTO.price() != null ? subscriptionTypeUpdateDTO.price() : subscribeEntity.getPrice())
                .productKey(subscriptionTypeUpdateDTO.productKey() != null ? subscriptionTypeUpdateDTO.productKey() : subscribeEntity.getProductKey())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        subscriptionTypeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subscription type", "id", id)
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}