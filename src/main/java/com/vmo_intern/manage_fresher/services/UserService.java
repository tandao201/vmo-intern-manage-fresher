package com.vmo_intern.manage_fresher.services;

import com.vmo_intern.manage_fresher.base.IBaseService;
import com.vmo_intern.manage_fresher.models.entities.UserEntity;
import com.vmo_intern.manage_fresher.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IBaseService<UserEntity> {

    @Autowired
    IUserRepository iUserRepository;
    @Override
    public UserEntity save(UserEntity model) {
        Date now = new Date();
        model.setCreatedAt(now);
        model.setUpdatedAt(now);
        return iUserRepository.save(model);
    }

    @Override
    public void save(List<UserEntity> models) {
        iUserRepository.saveAll(models);
    }

    @Override
    public int deleteById(Integer id) {
        if (iUserRepository.existsById(id)) {
            iUserRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public int update(UserEntity model) {
        Optional<UserEntity> optional = iUserRepository.findById(model.getId());
        if (optional.isPresent()) {
            model.setUpdatedAt(new Date());
            iUserRepository.save(UserEntity.clone(model));
            return 1;
        }
        return 0;
    }

    @Override
    public UserEntity findById(Integer id) {
        Optional<UserEntity> optional = iUserRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public UserEntity findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<UserEntity> findByIds(String ids) {
        return null;
    }

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) iUserRepository.findAll();
    }

    @Override
    public Page<UserEntity> findAllPaging(int page, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(page, pageSize, Sort.by(sortBy));
        Page<UserEntity> pageResult = iUserRepository.findAll(paging);
        if (pageResult.hasContent()) {
            return pageResult;
        }
        return null;
    }
}
