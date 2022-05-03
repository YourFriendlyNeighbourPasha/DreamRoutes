package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.Route;
import com.redscarf.dreamroutes.repositories.interfaces.RouteRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.RouteService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class RouteServiceImpl extends GenericServiceImpl<Route> implements RouteService {

    public RouteServiceImpl(RouteRepository repository) {
        super(repository);
    }
}
