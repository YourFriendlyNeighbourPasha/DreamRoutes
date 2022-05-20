package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.Freight;
import com.redscarf.dreamroutes.repositories.interfaces.FreightRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.FreightService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.FreightServiceImpl
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|03:09
 * @Version FreightServiceImpl: 1.0
 */

@Component
@Transactional
public class FreightServiceImpl extends GenericServiceImpl<Freight>
        implements FreightService {

    public FreightServiceImpl(FreightRepository repository) {
        super(repository);
    }
}
