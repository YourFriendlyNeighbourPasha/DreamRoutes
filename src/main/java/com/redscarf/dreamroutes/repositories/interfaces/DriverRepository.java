package com.redscarf.dreamroutes.repositories.interfaces;

import com.redscarf.dreamroutes.models.Driver;
import com.redscarf.dreamroutes.repositories.generics.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends GenericRepository<Driver> {
}