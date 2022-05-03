package com.redscarf.dreamroutes.repositories.interfaces;

import com.redscarf.dreamroutes.models.Salary;
import com.redscarf.dreamroutes.repositories.generics.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends GenericRepository<Salary> {
}