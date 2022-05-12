package com.redscarf.dreamroutes.services.generics.impls;

import com.redscarf.dreamroutes.models.BaseSequenceModel;
import com.redscarf.dreamroutes.repositories.generics.GenericSequenceRepository;
import com.redscarf.dreamroutes.services.generics.GenericSequenceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.GenericSequenceServiceImpl
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|02:40
 * @Version GenericSequenceServiceImpl: 1.0
 */

public class GenericSequenceServiceImpl<T extends BaseSequenceModel> implements GenericSequenceService<T> {

    protected final GenericSequenceRepository<T> repository;

    public GenericSequenceServiceImpl(GenericSequenceRepository<T> repository) {
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
    public T findById(Integer id) throws NoSuchElementException {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Boolean delete(T entity) {
        repository.delete(entity);
        return repository.findById(entity.getId()).isEmpty();
    }

    @Override
    public Boolean deleteById(Integer id) {
        repository.deleteById(id);
        return repository.findById(id).isEmpty();
    }

}
