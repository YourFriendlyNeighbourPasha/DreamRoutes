package com.redscarf.dreamroutes.repositories.interfaces.sequences;

import com.redscarf.dreamroutes.models.City;
import com.redscarf.dreamroutes.repositories.generics.GenericSequenceRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends GenericSequenceRepository<City> {
}