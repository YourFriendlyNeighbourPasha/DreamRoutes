package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.Vehicle;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.VehicleService;
import org.springframework.stereotype.Component;

@Component
public class VehicleServiceImpl extends GenericServiceImpl<Vehicle> implements VehicleService {
}
