package com.vmo_intern.manage_fresher.repositories;

import com.vmo_intern.manage_fresher.models.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface IUserRepository extends PagingAndSortingRepository<UserEntity, Integer> {
    Page<UserEntity> findByEmailContaining(Pageable pageable, String email);

    Page<UserEntity> findByProgrammingLanguageEntitiesId(Pageable pageable, int programmingLanguageEntitiesId);

    Page<UserEntity> findByIdOffice(Pageable pageable, int idOffice);

    Page<UserEntity> findByAverageScoreBetween(Pageable pageable, double from, double to);

    @Query(value = "SELECT * FROM manage_fresher.user u join" +
            " (select s.user_entity_id, avg(s.result) as score_avg from manage_fresher.user_score_entities s group by s.user_entity_id )" +
            " s on s.user_entity_id = u.id where s.score_avg between :from and :to ", nativeQuery = true)
    Page<UserEntity> findOrdersByTotalPrice(Pageable pageable, @Param("from") double from, @Param("to") double to);
}
