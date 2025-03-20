package com.yanvelasco.rasmooplus.model.repositories;

import com.yanvelasco.rasmooplus.model.entities.UserPaymentInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaymentInfoRepository extends JpaRepository<UserPaymentInfoEntity, Long> {
}
