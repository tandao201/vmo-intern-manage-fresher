package com.vmo_intern.manage_fresher.repositories;

import com.vmo_intern.manage_fresher.models.entities.UserEntity;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface IUserRepository extends PagingAndSortingRepository<UserEntity, Integer> {
}
