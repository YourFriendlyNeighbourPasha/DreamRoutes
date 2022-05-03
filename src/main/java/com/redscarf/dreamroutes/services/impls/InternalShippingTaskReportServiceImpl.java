package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.InternalShippingTaskReport;
import com.redscarf.dreamroutes.repositories.interfaces.InternalShippingTaskReportRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.InternalShippingTaskReportService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class InternalShippingTaskReportServiceImpl extends GenericServiceImpl<InternalShippingTaskReport>
        implements InternalShippingTaskReportService {

    public InternalShippingTaskReportServiceImpl(InternalShippingTaskReportRepository repository) {
        super(repository);
    }
}
