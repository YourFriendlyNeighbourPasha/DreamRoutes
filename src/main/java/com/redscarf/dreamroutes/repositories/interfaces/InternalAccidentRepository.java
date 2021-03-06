package com.redscarf.dreamroutes.repositories.interfaces;

import com.redscarf.dreamroutes.models.InternalAccident;
import com.redscarf.dreamroutes.repositories.generics.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalAccidentRepository
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|02:01
 * @Version InternalAccidentRepository: 1.0
 */

@Repository
public interface InternalAccidentRepository extends GenericRepository<InternalAccident> {

    InternalAccident findByInternalShippingTaskReportId(UUID internalShippingTaskReportId);

}