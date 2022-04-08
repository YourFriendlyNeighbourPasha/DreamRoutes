package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.DriverLicense;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.DriverLicenseService;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverLicenseServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|02:58
 * @Version DriverLicenseServiceImpl: 1.0
 */

@Component
public class DriverLicenseServiceImpl extends GenericServiceImpl<DriverLicense>
        implements DriverLicenseService {
}
