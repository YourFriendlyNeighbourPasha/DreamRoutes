package com.redscarf.dreamroutes.repositories.interfaces;

import com.redscarf.dreamroutes.models.Vehicle;
import com.redscarf.dreamroutes.repositories.generics.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends GenericRepository<Vehicle> {
}