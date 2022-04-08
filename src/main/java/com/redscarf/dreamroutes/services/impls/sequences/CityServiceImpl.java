package com.redscarf.dreamroutes.services.impls.sequences;

import com.redscarf.dreamroutes.models.City;
import com.redscarf.dreamroutes.repositories.interfaces.sequences.CityRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericSequenceServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.sequences.CityService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.CityServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|03:14
 * @Version CityServiceImpl: 1.0
 */

@Component
@Transactional
public class CityServiceImpl extends GenericSequenceServiceImpl<City>
        implements CityService {

    public CityServiceImpl(CityRepository repository) {
        super(repository);
    }

}
