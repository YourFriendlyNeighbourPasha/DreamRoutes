package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.InternalAccident;
import com.redscarf.dreamroutes.repositories.interfaces.InternalAccidentRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.InternalAccidentService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class InternalAccidentServiceImpl extends GenericServiceImpl<InternalAccident>
        implements InternalAccidentService {

    public InternalAccidentServiceImpl(InternalAccidentRepository repository) {
        super(repository);
    }
}
