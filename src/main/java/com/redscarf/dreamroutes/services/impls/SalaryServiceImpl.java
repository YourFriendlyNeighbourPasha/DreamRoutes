package com.redscarf.dreamroutes.services.impls;

import com.redscarf.dreamroutes.models.Salary;
import com.redscarf.dreamroutes.services.generics.impls.GenericServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.SalaryService;
import org.springframework.stereotype.Component;

@Component
public class SalaryServiceImpl extends GenericServiceImpl<Salary>
        implements SalaryService {
}
