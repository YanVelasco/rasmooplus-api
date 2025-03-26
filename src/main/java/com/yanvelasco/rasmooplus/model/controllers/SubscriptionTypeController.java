package com.yanvelasco.rasmooplus.model.controllers;

import com.yanvelasco.rasmooplus.model.dto.SubscriptionTypeDTO;
import com.yanvelasco.rasmooplus.model.dto.SubscriptionTypeUpdateDTO;
import com.yanvelasco.rasmooplus.model.entities.SubscriptionTypeEntity;
import com.yanvelasco.rasmooplus.model.services.SubscriptionTypeEntityService;
import com.yanvelasco.rasmooplus.model.services.impl.SubscriptionTypeEntityServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subscriptions-type")
@Tag(name = "Subscription Type", description = "Endpoints for managing subscription types")
public class SubscriptionTypeController {

    private final SubscriptionTypeEntityService subscriptionTypeEntityService;

    public SubscriptionTypeController(SubscriptionTypeEntityServiceImpl subscriptionTypeEntityServiceImpl) {
        this.subscriptionTypeEntityService = subscriptionTypeEntityServiceImpl;
    }

    @GetMapping
    @Operation(summary = "Get all subscription types", description = "Retrieve a list of all subscription types")
    public ResponseEntity<List<SubscriptionTypeEntity>> findAll() {
        return subscriptionTypeEntityService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get subscription type by ID", description = "Retrieve a subscription type by its ID")
    public ResponseEntity<SubscriptionTypeEntity> findById(@PathVariable Long id) {
        return subscriptionTypeEntityService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new subscription type", description = "Create a new subscription type")
    public ResponseEntity<SubscriptionTypeEntity> create(@RequestBody @Valid SubscriptionTypeDTO subscriptionTypeDTO) {
        return subscriptionTypeEntityService.create(subscriptionTypeDTO);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update a subscription type", description = "Update an existing subscription type by its ID")
    public ResponseEntity<SubscriptionTypeEntity> update(@PathVariable Long id,
                                                         @RequestBody @Valid SubscriptionTypeUpdateDTO subscriptionTypeUpdateDTO) {
        return subscriptionTypeEntityService.update(id, subscriptionTypeUpdateDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a subscription type", description = "Delete a subscription type by its ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return subscriptionTypeEntityService.delete(id);
    }
}
