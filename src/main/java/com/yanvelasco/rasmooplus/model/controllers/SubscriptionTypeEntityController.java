package com.yanvelasco.rasmooplus.model.controllers;

import com.yanvelasco.rasmooplus.model.dto.SubscriptionTypeDTO;
import com.yanvelasco.rasmooplus.model.dto.SubscriptionTypeUpdateDTO;
import com.yanvelasco.rasmooplus.model.entities.SubscriptionTypeEntity;
import com.yanvelasco.rasmooplus.model.services.SubscriptionTypeEntityService;
import com.yanvelasco.rasmooplus.model.services.impl.SubscriptionTypeEntityServiceImpl;
import jakarta.validation.Valid;
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
    public ResponseEntity<SubscriptionTypeEntity> create(@RequestBody @Valid SubscriptionTypeDTO subscriptionTypeDTO) {
        return subscriptionTypeEntityService.create(subscriptionTypeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionTypeEntity> update(@PathVariable Long id,
                                                         @RequestBody @Valid SubscriptionTypeUpdateDTO subscriptionTypeUpdateDTO) {
        return subscriptionTypeEntityService.update(id, subscriptionTypeUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return subscriptionTypeEntityService.delete(id);
    }


}
