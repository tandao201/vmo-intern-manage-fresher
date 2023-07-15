package com.vmo_intern.manage_fresher.repositories;

import com.vmo_intern.manage_fresher.models.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface IUserRepository extends PagingAndSortingRepository<UserEntity, Integer> {
    Page<UserEntity> findByEmailContaining(Pageable pageable, String email);
    Page<UserEntity> findByProgrammingLanguageEntitiesId(Pageable pageable, int programmingLanguageEntitiesId);
}
