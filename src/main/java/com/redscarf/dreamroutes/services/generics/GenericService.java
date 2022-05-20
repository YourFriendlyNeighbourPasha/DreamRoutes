package com.redscarf.dreamroutes.services.generics;


import org.springframework.data.domain.Page;

import java.util.UUID;

public interface GenericService<T> {

    Page<T> findAll(Integer pageNumber, Integer pageSize);

    T save(T entity);

    T findById(UUID id);

    boolean delete(T entity);

    boolean deleteById(UUID id);

}
