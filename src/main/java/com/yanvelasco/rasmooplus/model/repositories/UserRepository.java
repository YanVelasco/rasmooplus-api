package com.yanvelasco.rasmooplus.model.repositories;

import com.yanvelasco.rasmooplus.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}