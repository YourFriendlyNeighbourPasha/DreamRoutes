package com.redscarf.dreamroutes.repositories.interfaces;

import com.redscarf.dreamroutes.models.InternalShippingTaskReport;
import com.redscarf.dreamroutes.repositories.generics.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InternalShippingTaskReportRepository extends GenericRepository<InternalShippingTaskReport> {

    InternalShippingTaskReport findByInternalShippingTaskId(UUID internalShippingTaskId);

}