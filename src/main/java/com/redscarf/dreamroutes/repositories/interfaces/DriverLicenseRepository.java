package com.redscarf.dreamroutes.repositories.interfaces;

import com.redscarf.dreamroutes.models.DriverLicense;
import com.redscarf.dreamroutes.repositories.generics.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DriverLicenseRepository extends GenericRepository<DriverLicense> {

    DriverLicense findByDriverId(UUID driverId);

}