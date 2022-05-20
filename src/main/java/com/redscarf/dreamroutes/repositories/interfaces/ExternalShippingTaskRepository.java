package com.redscarf.dreamroutes.repositories.interfaces;

import com.redscarf.dreamroutes.models.ExternalShippingTask;
import com.redscarf.dreamroutes.repositories.generics.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExternalShippingTaskRepository extends GenericRepository<ExternalShippingTask> {

    List<ExternalShippingTask> findByDriverId(UUID driverId);

    List<ExternalShippingTask> findByExtraDriverId(UUID extraDriverId);

}