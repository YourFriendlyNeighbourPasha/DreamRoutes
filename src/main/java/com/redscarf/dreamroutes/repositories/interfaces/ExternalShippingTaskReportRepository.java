package com.redscarf.dreamroutes.repositories.interfaces;

import com.redscarf.dreamroutes.models.ExternalShippingTaskReport;
import com.redscarf.dreamroutes.repositories.generics.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExternalShippingTaskReportRepository extends GenericRepository<ExternalShippingTaskReport> {

    ExternalShippingTaskReport findByExternalShippingTaskId(UUID externalShippingTaskId);

}