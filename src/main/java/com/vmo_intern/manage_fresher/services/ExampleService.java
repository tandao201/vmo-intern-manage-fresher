package com.vmo_intern.manage_fresher.services;

import com.vmo_intern.manage_fresher.base.IBaseService;
import com.vmo_intern.manage_fresher.models.entities.ExampleEntity;
import com.vmo_intern.manage_fresher.repositories.IExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExampleService implements IBaseService<ExampleEntity> {

    @Autowired
    private IExampleRepository iExampleRepository;
    @Override
    public ExampleEntity save(ExampleEntity model) {
        Date now = new Date();
        model.setCreatedAt(now);
        model.setUpdatedAt(now);
        return iExampleRepository.save(model);
    }

    @Override
    public void save(List<ExampleEntity> models) {
        iExampleRepository.saveAll(models);
    }

    @Override
    public int deleteById(Integer id) {
        if (iExampleRepository.existsById(id)) {
            iExampleRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public int update(ExampleEntity model) {
        Optional<ExampleEntity> optional = iExampleRepository.findById(model.getId());
        if (optional.isPresent()) {
            model.setUpdatedAt(new Date());
            iExampleRepository.save(ExampleEntity.clone(model));
            return 1;
        }
        return 0;

    }

    @Override
    public ExampleEntity findById(Integer id) {
        Optional<ExampleEntity> optional = iExampleRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public ExampleEntity findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<ExampleEntity> findByIds(String ids) {
        return null;
    }

    @Override
    public List<ExampleEntity> findAll() {
        return iExampleRepository.findAll();
    }

    @Override
    public Page<ExampleEntity> findAllPaging(int page, int pageSize, String sortBy) {
        return null;
    }
}
