package com.yanvelasco.rasmooplus.model.services.impl;

import com.yanvelasco.rasmooplus.exceptions.IsEmptyException;
import com.yanvelasco.rasmooplus.exceptions.ResourceNotFoundException;
import com.yanvelasco.rasmooplus.model.controllers.SubscriptionTypeController;
import com.yanvelasco.rasmooplus.model.dto.SubscriptionTypeDTO;
import com.yanvelasco.rasmooplus.model.dto.SubscriptionTypeUpdateDTO;
import com.yanvelasco.rasmooplus.model.entities.SubscriptionTypeEntity;
import com.yanvelasco.rasmooplus.model.mapper.SubscriptionTypeMapper;
import com.yanvelasco.rasmooplus.model.repositories.SubscriptionTypeRepository;
import com.yanvelasco.rasmooplus.model.services.SubscriptionTypeEntityService;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionTypeEntityServiceImpl implements SubscriptionTypeEntityService {

    private final SubscriptionTypeRepository subscriptionTypeRepository;
    private final SubscriptionTypeMapper subscriptionTypeMapper;

    public SubscriptionTypeEntityServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository,
                                             SubscriptionTypeMapper subscriptionTypeMapper) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
        this.subscriptionTypeMapper = subscriptionTypeMapper;
    }

    @Override
    public ResponseEntity<List<SubscriptionTypeEntity>> findAll() {
        List<SubscriptionTypeEntity> list = subscriptionTypeRepository.findAll();
        if (list.isEmpty()) {
            throw new IsEmptyException("Has no subscriptions type registered");
        }

        for (SubscriptionTypeEntity subscriptionType : list) {
            subscriptionType.add(WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(SubscriptionTypeController.class)
                            .findById(subscriptionType.getId())).withSelfRel()
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @Override
    public ResponseEntity<SubscriptionTypeEntity> findById(Long id) {
        var subscriptionTypeEntity = subscriptionTypeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subscription type", "id", id)
        );

        subscriptionTypeEntity.add(WebMvcLinkBuilder.linkTo(
               WebMvcLinkBuilder.methodOn(SubscriptionTypeController.class)
                        .findById(id)).withSelfRel()
        );

        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeEntity);
    }

    @Override
    public ResponseEntity<SubscriptionTypeEntity> create(SubscriptionTypeDTO subscriptionTypeDTO) {
        var subscriptionTypeEntity = SubscriptionTypeMapper.toEntity(subscriptionTypeDTO);

        subscriptionTypeEntity.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(SubscriptionTypeController.class)
                        .findById(subscriptionTypeEntity.getId())).withSelfRel()
        );

        subscriptionTypeRepository.save(subscriptionTypeEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionTypeEntity);
    }

    @Override
    public ResponseEntity<SubscriptionTypeEntity> update(Long id, SubscriptionTypeUpdateDTO subscriptionTypeUpdateDTO) {
        var subscribeEntity = subscriptionTypeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subscription type", "id", id)
        );
        var update = SubscriptionTypeMapper.toEntity(subscriptionTypeUpdateDTO, subscribeEntity);

        update.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(SubscriptionTypeController.class)
                        .findById(update.getId())).withSelfRel()
        );

        subscriptionTypeRepository.save(update);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        subscriptionTypeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subscription type", "id", id)
        );
        subscriptionTypeRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}