package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.DriverLicense;
import com.redscarf.dreamroutes.repositories.interfaces.DriverLicenseRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.DriverLicenseService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverLicenseServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|02:58
 * @Version DriverLicenseServiceImpl: 1.0
 */

@Component
@Transactional
public class DriverLicenseServiceImpl extends GenericServiceImpl<DriverLicense>
        implements DriverLicenseService {

    public DriverLicenseServiceImpl(DriverLicenseRepository repository) {
        super(repository);
    }

}
