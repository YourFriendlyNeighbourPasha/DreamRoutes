package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.ExternalShippingTask;
import com.redscarf.dreamroutes.repositories.interfaces.ExternalShippingTaskRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.ExternalShippingTaskService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalShippingTaskServiceImpl
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|03:08
 * @Version ExternalShippingTaskServiceImpl: 1.0
 */

@Component
@Transactional
public class ExternalShippingTaskServiceImpl extends GenericServiceImpl<ExternalShippingTask>
        implements ExternalShippingTaskService {

    public ExternalShippingTaskServiceImpl(ExternalShippingTaskRepository repository) {
        super(repository);
    }
}
