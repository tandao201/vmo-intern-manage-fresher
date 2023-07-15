package com.vmo_intern.manage_fresher.services;

import com.vmo_intern.manage_fresher.base.IBaseService;
import com.vmo_intern.manage_fresher.models.entities.ScoreEntity;
import com.vmo_intern.manage_fresher.repositories.IScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ScoreService implements IBaseService<ScoreEntity> {

    @Autowired
    IScoreRepository iScoreRepository;
    @Override
    public ScoreEntity save(ScoreEntity model) {
        Date now = new Date();
        model.setCreatedAt(now);
        model.setUpdatedAt(now);
        return iScoreRepository.save(model);
    }

    @Override
    public void save(List<ScoreEntity> models) {
        iScoreRepository.saveAll(models);
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public int update(ScoreEntity model) {
        return 0;
    }

    @Override
    public ScoreEntity findById(Integer id) {
        return null;
    }

    @Override
    public ScoreEntity findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<ScoreEntity> findByIds(String ids) {
        return null;
    }

    @Override
    public List<ScoreEntity> findAll() {
        return null;
    }

    @Override
    public Page<ScoreEntity> findAllPaging(int page, int pageSize, String sortBy) {
        return null;
    }

    public void updateList(int userEntityId, List<ScoreEntity> models) {
        save(models);
    }
}
