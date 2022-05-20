package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.freight.FreightCreateDto;
import com.redscarf.dreamroutes.dto.freight.FreightDto;
import com.redscarf.dreamroutes.mappers.resolvers.UuidResolver;
import com.redscarf.dreamroutes.models.Freight;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.FreightMapper
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 12.05.2022|03:52
 * @Version FreightMapper: 1.0
 */

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class FreightMapper
        implements GenericMapper<Freight, FreightDto, FreightCreateDto> {

    protected UuidResolver uuidResolver;

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromString(dto.getId()))")
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract Freight fromDtoToEntity(FreightDto dto);

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromUUID(entity.getId()))")
    public abstract FreightDto fromEntityToDto(Freight entity);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract Freight fromCreateDtoToEntity(FreightCreateDto createDto);

    @Autowired
    public void setUuidResolver(UuidResolver uuidResolver) {
        this.uuidResolver = uuidResolver;
    }
}
