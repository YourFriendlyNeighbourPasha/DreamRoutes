package com.redscarf.dreamroutes.repositories.interfaces;

import com.redscarf.dreamroutes.models.Freight;
import com.redscarf.dreamroutes.repositories.generics.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreightRepository extends GenericRepository<Freight> {
}