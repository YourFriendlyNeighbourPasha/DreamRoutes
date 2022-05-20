package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.driver.DriverCreateDto;
import com.redscarf.dreamroutes.dto.driver.DriverDto;
import com.redscarf.dreamroutes.mappers.resolvers.UuidResolver;
import com.redscarf.dreamroutes.models.Driver;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverMapper
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 12.05.2022|02:14
 * @Version DriverMapper: 1.0
 */

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class DriverMapper implements GenericMapper<Driver, DriverDto, DriverCreateDto> {

    protected UuidResolver uuidResolver;

    @Override
    @Mapping(target = "id", ignore = true)
    public abstract DriverDto fromEntityToDto(Driver entity);

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromString(dto.getId()))")
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "driverLicense", ignore = true)
    public abstract Driver fromDtoToEntity(DriverDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "driverLicense", ignore = true)
    public abstract Driver fromCreateDtoToEntity(DriverCreateDto createDto);

    @AfterMapping
    protected void resolveUUID(Driver sourceEntity, @MappingTarget DriverDto targetDto) {
        targetDto.setId(uuidResolver.fromUUID(sourceEntity.getId()));
    }


    @Autowired
    public void setUuidResolver(UuidResolver uuidResolver) {
        this.uuidResolver = uuidResolver;
    }
}
