package com.vmo_intern.manage_fresher.services;

import com.vmo_intern.manage_fresher.base.IBaseService;
import com.vmo_intern.manage_fresher.models.entities.OfficeEntity;
import com.vmo_intern.manage_fresher.repositories.IOfficeRepository;
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
public class OfficeService implements IBaseService<OfficeEntity> {

    @Autowired
    IOfficeRepository iOfficeRepository;

    @Override
    public OfficeEntity save(OfficeEntity model) {
        Date now = new Date();
        model.setCreatedAt(now);
        model.setUpdatedAt(now);
        return iOfficeRepository.save(model);
    }

    @Override
    public void save(List<OfficeEntity> models) {
        iOfficeRepository.saveAll(models);
    }

    @Override
    public int deleteById(Integer id) {
        if (iOfficeRepository.existsById(id)) {
            iOfficeRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public int update(OfficeEntity model) {
        Optional<OfficeEntity> optional = iOfficeRepository.findById(model.getId());
        if (optional.isPresent()) {
            model.setUpdatedAt(new Date());
            iOfficeRepository.save(OfficeEntity.clone(model));
            return 1;
        }
        return 0;
    }

    @Override
    public OfficeEntity findById(Integer id) {
        Optional<OfficeEntity> optional = iOfficeRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public OfficeEntity findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<OfficeEntity> findByIds(String ids) {
        return null;
    }

    @Override
    public List<OfficeEntity> findAll() {
        return (List<OfficeEntity>) iOfficeRepository.findAll();
    }

    @Override
    public Page<OfficeEntity> findAllPaging(int page, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(page, pageSize, Sort.by(sortBy));
        Page<OfficeEntity> pageResult = iOfficeRepository.findAll(paging);
        if (pageResult.hasContent()) {
            return pageResult;
        }
        return null;
    }
}
