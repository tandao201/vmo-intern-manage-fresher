package com.vmo_intern.manage_fresher.repositories;

import com.vmo_intern.manage_fresher.models.entities.AuthenticationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAuthenticationRepository extends JpaRepository<AuthenticationEntity, Integer> {
    Optional<AuthenticationEntity> findByUsernameAndPassword(String username, String password);
    Optional<AuthenticationEntity> findByUsername(String username);

    Boolean existsByUsername(String username);
}
