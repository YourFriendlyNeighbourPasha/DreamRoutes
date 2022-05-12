package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.vehicle.VehicleCreateDto;
import com.redscarf.dreamroutes.dto.vehicle.VehicleDto;
import com.redscarf.dreamroutes.mappers.resolvers.UuidResolver;
import com.redscarf.dreamroutes.models.Vehicle;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.VehicleMapper
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 12.05.2022|03:57
 * @Version VehicleMapper: 1.0
 */

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class VehicleMapper
        implements GenericMapper<Vehicle, VehicleDto, VehicleCreateDto> {

    protected UuidResolver uuidResolver;

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromUUID(entity.getId()))")
    public abstract VehicleDto fromEntityToDto(Vehicle entity);

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromString(dto.getId()))")
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract Vehicle fromDtoToEntity(VehicleDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract Vehicle fromCreateDtoToEntity(VehicleCreateDto createDto);

    @Autowired
    public void setUuidResolver(UuidResolver uuidResolver) {
        this.uuidResolver = uuidResolver;
    }
}
