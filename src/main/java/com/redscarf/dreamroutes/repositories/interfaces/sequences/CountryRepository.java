package com.redscarf.dreamroutes.repositories.interfaces.sequences;

import com.redscarf.dreamroutes.models.Country;
import com.redscarf.dreamroutes.repositories.generics.GenericSequenceRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends GenericSequenceRepository<Country> {
}