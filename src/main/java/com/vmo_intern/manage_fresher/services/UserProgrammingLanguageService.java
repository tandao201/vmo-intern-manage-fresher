package com.vmo_intern.manage_fresher.services;

import com.vmo_intern.manage_fresher.base.IBaseService;
import com.vmo_intern.manage_fresher.models.entities.UserProgrammingLanguageEntity;
import com.vmo_intern.manage_fresher.repositories.IUserProgrammingLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserProgrammingLanguageService implements IBaseService<UserProgrammingLanguageEntity> {

    @Autowired
    IUserProgrammingLanguageRepository iUserProgrammingLanguageRepository;
    @Override
    public UserProgrammingLanguageEntity save(UserProgrammingLanguageEntity model) {
        return null;
    }

    @Override
    public void save(List<UserProgrammingLanguageEntity> models) {
        System.out.println("Save list: "+models);
        iUserProgrammingLanguageRepository.saveAll(models);
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public int update(UserProgrammingLanguageEntity model) {
        return 0;
    }

    @Override
    public UserProgrammingLanguageEntity findById(Integer id) {
        return null;
    }

    @Override
    public UserProgrammingLanguageEntity findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<UserProgrammingLanguageEntity> findByIds(String ids) {
        return null;
    }

    @Override
    public List<UserProgrammingLanguageEntity> findAll() {
        return null;
    }

    @Override
    public Page<UserProgrammingLanguageEntity> findAllPaging(int page, int pageSize, String sortBy) {
        return null;
    }

    public void updateList(int userEntityId, List<UserProgrammingLanguageEntity> models) {
        save(models);
    }
}
