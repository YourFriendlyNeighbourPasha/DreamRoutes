package com.redscarf.dreamroutes.repositories.interfaces;

import com.redscarf.dreamroutes.models.Route;
import com.redscarf.dreamroutes.repositories.generics.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends GenericRepository<Route> {
}
