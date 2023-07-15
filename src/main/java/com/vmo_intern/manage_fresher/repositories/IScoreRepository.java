package com.vmo_intern.manage_fresher.repositories;

import com.vmo_intern.manage_fresher.models.entities.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface IScoreRepository extends JpaRepository<ScoreEntity, Integer> {
    int deleteByIdFresher(int idFresher);

    boolean existsByIdFresher(int idFresher);
}
