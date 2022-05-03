package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.ExternalAccident;
import com.redscarf.dreamroutes.repositories.interfaces.ExternalAccidentRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.ExternalAccidentService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalAccidentServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|03:06
 * @Version ExternalAccidentServiceImpl: 1.0
 */

@Component
@Transactional
public class ExternalAccidentServiceImpl extends GenericServiceImpl<ExternalAccident>
        implements ExternalAccidentService {

    public ExternalAccidentServiceImpl(ExternalAccidentRepository repository) {
        super(repository);
    }
}
