package com.redscarf.dreamroutes.services.generics.impls;

import com.redscarf.dreamroutes.models.BaseModel;
import com.redscarf.dreamroutes.repositories.generics.GenericRepository;
import com.redscarf.dreamroutes.services.generics.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.GenericServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|02:28
 * @Version GenericServiceImpl: 1.0
 */

public class GenericServiceImpl<T extends BaseModel> implements GenericService<T> {

    protected final GenericRepository<T> repository;

    public GenericServiceImpl(GenericRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public Page<T> findAll(Integer pageNumber, Integer pageSize) {
        return repository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T findById(UUID id) throws NoSuchElementException {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public boolean delete(T entity) {
        repository.delete(entity);
        return repository.findById(entity.getId()).isEmpty();
    }

    @Override
    public boolean deleteById(UUID id) {
        repository.deleteById(id);
        return repository.findById(id).isEmpty();
    }

    @Override
    public long count() {
        return repository.findAll().spliterator().getExactSizeIfKnown();
    }
}
