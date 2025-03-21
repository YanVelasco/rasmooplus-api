package com.yanvelasco.rasmooplus.model.services.impl;

import com.yanvelasco.rasmooplus.exceptions.IsEmptyException;
import com.yanvelasco.rasmooplus.exceptions.ResourceNotFoundException;
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
    public ResponseEntity<SubscriptionTypeEntity> create(SubscriptionTypeEntity subscriptionTypeEntity) {
        subscriptionTypeRepository.save(subscriptionTypeEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionTypeEntity);
    }

    @Override
    public ResponseEntity<SubscriptionTypeEntity> update(Long id, SubscriptionTypeEntity subscriptionTypeEntity) {
        subscriptionTypeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subscription type", "id", id)
        );
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeEntity);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        subscriptionTypeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subscription type", "id", id)
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}