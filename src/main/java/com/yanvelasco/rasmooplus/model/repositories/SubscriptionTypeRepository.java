package com.yanvelasco.rasmooplus.model.repositories;

import com.yanvelasco.rasmooplus.model.entities.SubscriptionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionTypeEntity, Long> {
}
