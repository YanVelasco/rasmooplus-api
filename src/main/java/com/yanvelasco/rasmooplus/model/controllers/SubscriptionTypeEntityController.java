package com.yanvelasco.rasmooplus.model.controllers;

import com.yanvelasco.rasmooplus.model.entities.SubscriptionTypeEntity;
import com.yanvelasco.rasmooplus.model.services.SubscriptionTypeEntityService;
import com.yanvelasco.rasmooplus.model.services.impl.SubscriptionTypeEntityServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subscriptions-type")
public class SubscriptionTypeEntityController {

    private final SubscriptionTypeEntityService subscriptionTypeEntityService;

    public SubscriptionTypeEntityController(SubscriptionTypeEntityServiceImpl subscriptionTypeEntityServiceImpl) {
        this.subscriptionTypeEntityService = subscriptionTypeEntityServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionTypeEntity>> findAll() {
        return subscriptionTypeEntityService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionTypeEntity> findById(@PathVariable Long id) {
        return subscriptionTypeEntityService.findById(id);
    }

    @PostMapping
    public ResponseEntity<SubscriptionTypeEntity> create(@RequestBody SubscriptionTypeEntity subscriptionTypeEntity) {
        return subscriptionTypeEntityService.create(subscriptionTypeEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionTypeEntity> update(@PathVariable Long id,
                                                         @RequestBody SubscriptionTypeEntity subscriptionTypeEntity) {
        return subscriptionTypeEntityService.update(id, subscriptionTypeEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return subscriptionTypeEntityService.delete(id);
    }


}
