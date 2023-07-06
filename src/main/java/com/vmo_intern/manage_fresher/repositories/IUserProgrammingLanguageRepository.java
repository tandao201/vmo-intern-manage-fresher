package com.vmo_intern.manage_fresher.repositories;

import com.vmo_intern.manage_fresher.models.entities.UserProgrammingLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserProgrammingLanguageRepository extends JpaRepository<UserProgrammingLanguageEntity, Integer> {
    public List<UserProgrammingLanguageEntity> findAllByUserEntityId(int userEntityId);

    public void deleteByUserEntityId(int userEntityId);
}
