package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.InternalShippingTask;
import com.redscarf.dreamroutes.repositories.interfaces.InternalShippingTaskRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.InternalShippingTaskService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class InternalShippingTaskServiceImpl extends GenericServiceImpl<InternalShippingTask>
        implements InternalShippingTaskService {

    public InternalShippingTaskServiceImpl(InternalShippingTaskRepository repository) {
        super(repository);
    }
}
