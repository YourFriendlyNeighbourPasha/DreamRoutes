package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.Driver;
import com.redscarf.dreamroutes.repositories.interfaces.DriverRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.DriverService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|03:05
 * @Version DriverServiceImpl: 1.0
 */

@Component
@Transactional
public class DriverServiceImpl extends GenericServiceImpl<Driver>
        implements DriverService {

    public DriverServiceImpl(DriverRepository repository) {
        super(repository);
    }
}
