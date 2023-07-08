package com.vmo_intern.manage_fresher.services;

import com.vmo_intern.manage_fresher.base.IBaseService;
import com.vmo_intern.manage_fresher.models.entities.AuthenticationEntity;
import com.vmo_intern.manage_fresher.models.entities.UserEntity;
import com.vmo_intern.manage_fresher.repositories.IAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService implements IBaseService<AuthenticationEntity> {

    @Autowired
    IAuthenticationRepository authenticationRepository;
    @Override
    public AuthenticationEntity save(AuthenticationEntity model) {
        if (!authenticationRepository.existsByUsername(model.getUsername())) {
            Date now = new Date();
            model.setCreatedAt(now);
            model.setUpdatedAt(now);
            return authenticationRepository.save(model);
        }
        return null;
    }

    @Override
    public void save(List<AuthenticationEntity> models) {
        authenticationRepository.saveAll(models);
    }

    @Override
    public int deleteById(Integer id) {
        if (authenticationRepository.existsById(id)) {
            authenticationRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public int update(AuthenticationEntity model) {
        Optional<AuthenticationEntity> optional = authenticationRepository.findById(model.getId());
        if (optional.isPresent()) {
            model.setUpdatedAt(new Date());
            authenticationRepository.save(AuthenticationEntity.clone(model));
            return 1;
        }
        return 0;
    }

    @Override
    public AuthenticationEntity findById(Integer id) {
        return null;
    }

    @Override
    public AuthenticationEntity findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<AuthenticationEntity> findByIds(String ids) {
        return null;
    }

    @Override
    public List<AuthenticationEntity> findAll() {
        return null;
    }

    @Override
    public Page<AuthenticationEntity> findAllPaging(int page, int pageSize, String sortBy) {
        return null;
    }

    public AuthenticationEntity findByUsernameAndPassword(String username, String password) {
        Optional<AuthenticationEntity> optional = authenticationRepository.findByUsernameAndPassword(username, password);
        return optional.orElse(null);
    }

    public AuthenticationEntity findByUsername(String username) {
        Optional<AuthenticationEntity> optional = authenticationRepository.findByUsername(username);
        return optional.orElse(null);
    }
}
