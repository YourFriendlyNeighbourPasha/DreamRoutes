package com.redscarf.dreamroutes.services.impls.sequences;

import com.redscarf.dreamroutes.models.DriverLicenseCategory;
import com.redscarf.dreamroutes.repositories.interfaces.sequences.DriverLicenseCategoryRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericSequenceServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.sequences.DriverLicenseCategoryService;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverLicenseCategoryServiceImpl
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|03:18
 * @Version DriverLicenseCategoryServiceImpl: 1.0
 */

@Component
public class DriverLicenseCategoryServiceImpl extends GenericSequenceServiceImpl<DriverLicenseCategory>
        implements DriverLicenseCategoryService {

    public DriverLicenseCategoryServiceImpl(DriverLicenseCategoryRepository repository) {
        super(repository);
    }

}
