package com.redscarf.dreamroutes.services.generics;

import com.redscarf.dreamroutes.models.BaseSequenceModel;
import org.springframework.data.domain.Page;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.GenericSequenceService
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|02:39
 * @Version GenericSequenceService: 1.0
 */

public interface GenericSequenceService<T extends BaseSequenceModel> {

    Page<T> findAll(Integer pageNumber, Integer pageSize);

    T save(T entity);

    T findById(Integer id);

    Boolean delete(T entity);

    Boolean deleteById(Integer id);

}
