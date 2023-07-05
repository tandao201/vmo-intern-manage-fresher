package com.vmo_intern.manage_fresher.base;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBaseService<T> {
    T save(T model);
    void save(List<T> models);
    int deleteById(Integer id);
    void deleteByIds(String ids);// eg：ids -> “1,2,3,4”
    int update(T model);
    T findById(Integer id);
    T findBy(String fieldName, Object value);
    List<T> findByIds(String ids); //eg：ids -> “1,2,3,4”
    List<T> findAll();
    Page<T> findAllPaging(int page, int pageSize, String sortBy);//获取所有
}
