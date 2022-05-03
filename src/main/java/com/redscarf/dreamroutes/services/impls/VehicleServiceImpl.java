package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.Vehicle;
import com.redscarf.dreamroutes.repositories.interfaces.VehicleRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.VehicleService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class VehicleServiceImpl extends GenericServiceImpl<Vehicle> implements VehicleService {

    public VehicleServiceImpl(VehicleRepository repository) {
        super(repository);
    }
}
