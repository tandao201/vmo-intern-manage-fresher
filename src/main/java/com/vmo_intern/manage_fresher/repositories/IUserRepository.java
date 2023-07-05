package com.vmo_intern.manage_fresher.repositories;

import com.vmo_intern.manage_fresher.models.entities.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository<UserEntity, Integer> {
}
