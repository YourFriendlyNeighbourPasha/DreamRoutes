package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.Salary;
import com.redscarf.dreamroutes.repositories.interfaces.SalaryRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.SalaryService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SalaryServiceImpl extends GenericServiceImpl<Salary>
        implements SalaryService {

    public SalaryServiceImpl(SalaryRepository repository) {
        super(repository);
    }
}
