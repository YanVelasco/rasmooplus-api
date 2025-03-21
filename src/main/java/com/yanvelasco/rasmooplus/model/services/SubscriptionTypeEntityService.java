package com.yanvelasco.rasmooplus.model.services;

import com.yanvelasco.rasmooplus.model.dto.SubscriptionTypeDTO;
import com.yanvelasco.rasmooplus.model.dto.SubscriptionTypeUpdateDTO;
import com.yanvelasco.rasmooplus.model.entities.SubscriptionTypeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubscriptionTypeEntityService {
    ResponseEntity<List<SubscriptionTypeEntity>> findAll();

    ResponseEntity<SubscriptionTypeEntity> findById(Long id);

    ResponseEntity<SubscriptionTypeEntity> create(SubscriptionTypeDTO subscriptionTypeDTO);

    ResponseEntity<SubscriptionTypeEntity> update(Long id, SubscriptionTypeUpdateDTO subscriptionTypeUpdateDTO);

    ResponseEntity<Void> delete(Long id);

}
