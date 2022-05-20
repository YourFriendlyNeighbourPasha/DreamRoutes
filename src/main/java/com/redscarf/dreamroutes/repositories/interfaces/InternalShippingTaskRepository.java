package com.redscarf.dreamroutes.repositories.interfaces;

import com.redscarf.dreamroutes.models.InternalShippingTask;
import com.redscarf.dreamroutes.repositories.generics.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InternalShippingTaskRepository extends GenericRepository<InternalShippingTask> {

    List<InternalShippingTask> findByDriverId(UUID driverId);

}