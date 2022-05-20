package com.redscarf.dreamroutes.repositories.interfaces;

import com.redscarf.dreamroutes.models.ExternalAccident;
import com.redscarf.dreamroutes.repositories.generics.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExternalAccidentRepository extends GenericRepository<ExternalAccident> {

    ExternalAccident findByExternalShippingTaskReportId(UUID externalShippingTaskReportId);

}