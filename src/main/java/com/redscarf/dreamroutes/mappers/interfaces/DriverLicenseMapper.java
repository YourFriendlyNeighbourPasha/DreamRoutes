package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.driverlicense.DriverLicenseCreateDto;
import com.redscarf.dreamroutes.dto.driverlicense.DriverLicenseDto;
import com.redscarf.dreamroutes.mappers.resolvers.UuidResolver;
import com.redscarf.dreamroutes.models.DriverLicense;
import com.redscarf.dreamroutes.services.interfaces.DriverService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverLicenseMapper
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 12.05.2022|02:24
 * @Version DriverLicenseMapper: 1.0
 */

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class DriverLicenseMapper
        implements GenericMapper<DriverLicense, DriverLicenseDto, DriverLicenseCreateDto> {

    protected DriverService driverService;
    protected UuidResolver uuidResolver;

    @Override
    @Mapping(target = "driverId", expression = "java(uuidResolver.fromUUID(entity.getDriver().getId()))")
    @Mapping(target = "id", expression = "java(uuidResolver.fromUUID(entity.getId()))")
    public abstract DriverLicenseDto fromEntityToDto(DriverLicense entity);

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromString(dto.getId()))")
    @Mapping(target = "driverLicenseCategories", ignore = true)
    @Mapping(target = "driver", expression = "java(driverService.findById(uuidResolver.fromString(dto.getDriverId())))")
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    public abstract DriverLicense fromDtoToEntity(DriverLicenseDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "driverLicenseCategories", ignore = true)
    @Mapping(target = "driver", expression = "java(driverService.findById(uuidResolver.fromString(createDto.getDriverId())))")
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    public abstract DriverLicense fromCreateDtoToEntity(DriverLicenseCreateDto createDto);

    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    @Autowired
    public void setUuidResolver(UuidResolver uuidResolver) {
        this.uuidResolver = uuidResolver;
    }
}
