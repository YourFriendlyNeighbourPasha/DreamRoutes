package com.redscarf.dreamroutes.services.interfaces;

import com.redscarf.dreamroutes.models.Salary;
import com.redscarf.dreamroutes.services.generics.GenericService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface SalaryService extends GenericService<Salary> {

    Salary calculateSalaryForDriverById(UUID driverId);

}
