package com.yanvelasco.rasmooplus.model.repositories;

import com.yanvelasco.rasmooplus.model.entities.UserTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserTypeEntity, Long> {
}
