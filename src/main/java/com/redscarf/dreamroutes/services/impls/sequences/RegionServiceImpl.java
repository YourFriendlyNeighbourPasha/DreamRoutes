package com.redscarf.dreamroutes.services.impls.sequences;

import com.redscarf.dreamroutes.models.Region;
import com.redscarf.dreamroutes.repositories.interfaces.sequences.RegionRepository;
import com.redscarf.dreamroutes.services.generics.impls.GenericSequenceServiceImpl;
import com.redscarf.dreamroutes.services.interfaces.sequences.RegionService;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.RegionServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|03:19
 * @Version RegionServiceImpl: 1.0
 */

@Component
public class RegionServiceImpl extends GenericSequenceServiceImpl<Region>
        implements RegionService {

    public RegionServiceImpl(RegionRepository repository) {
        super(repository);
    }

}
