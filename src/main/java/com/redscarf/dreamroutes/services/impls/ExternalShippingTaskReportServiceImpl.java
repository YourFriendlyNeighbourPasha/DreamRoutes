package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.ExternalShippingTaskReport;
import com.redscarf.dreamroutes.repositories.interfaces.ExternalShippingTaskReportRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.ExternalShippingTaskReportService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalShippingTaskReportServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|03:07
 * @Version ExternalShippingTaskReportServiceImpl: 1.0
 */

@Component
@Transactional
public class ExternalShippingTaskReportServiceImpl extends GenericServiceImpl<ExternalShippingTaskReport>
        implements ExternalShippingTaskReportService {

    public ExternalShippingTaskReportServiceImpl(ExternalShippingTaskReportRepository repository) {
        super(repository);
    }
}
