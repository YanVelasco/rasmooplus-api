package com.yanvelasco.rasmooplus.model.services;

import com.yanvelasco.rasmooplus.model.entities.SubscriptionTypeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubscriptionTypeEntityService {
    ResponseEntity<List<SubscriptionTypeEntity>> findAll();

    ResponseEntity<SubscriptionTypeEntity> findById(Long id);

    ResponseEntity<SubscriptionTypeEntity> create(SubscriptionTypeEntity subscriptionTypeEntity);

    ResponseEntity<SubscriptionTypeEntity> update(Long id, SubscriptionTypeEntity subscriptionTypeEntity);

    ResponseEntity<Void> delete(Long id);

}
