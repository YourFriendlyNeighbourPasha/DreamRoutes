package com.redscarf.dreamroutes.services.impls.sequences;

import com.redscarf.dreamroutes.models.Country;
import com.redscarf.dreamroutes.repositories.interfaces.sequences.CountryRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericSequenceServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.sequences.CountryService;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.CountryService
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|03:17
 * @Version CountryService: 1.0
 */

@Component
public class CountryServiceImpl extends GenericSequenceServiceImpl<Country>
        implements CountryService {

    public CountryServiceImpl(CountryRepository repository) {
        super(repository);
    }

}
