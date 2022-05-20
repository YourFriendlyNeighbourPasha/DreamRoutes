package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.salary.SalaryCreateDto;
import com.redscarf.dreamroutes.dto.salary.SalaryDto;
import com.redscarf.dreamroutes.mappers.resolvers.DecimalResolver;
import com.redscarf.dreamroutes.mappers.resolvers.UuidResolver;
import com.redscarf.dreamroutes.models.Salary;
import com.redscarf.dreamroutes.services.interfaces.DriverService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.SalaryMapper
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 12.05.2022|04:08
 * @Version SalaryMapper: 1.0
 */

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class SalaryMapper implements GenericMapper<Salary, SalaryDto, SalaryCreateDto> {

    protected DriverService driverService;
    protected UuidResolver uuidResolver;
    protected DecimalResolver decimalResolver;

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromUUID(entity.getId()))")
    @Mapping(target = "driverId", expression = "java(uuidResolver.fromUUID(entity.getDriver().getId()))")
    public abstract SalaryDto fromEntityToDto(Salary entity);

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromString(dto.getId()))")
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "driver", expression = "java(driverService.findById(uuidResolver.fromString(dto.getDriverId())))")
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract Salary fromDtoToEntity(SalaryDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "driver", expression = "java(driverService.findById(uuidResolver.fromString(createDto.getDriverId())))")
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract Salary fromCreateDtoToEntity(SalaryCreateDto createDto);

    @Autowired
    public void setUuidResolver(UuidResolver uuidResolver) {
        this.uuidResolver = uuidResolver;
    }

    @Autowired
    public void setDecimalResolver(DecimalResolver decimalResolver) {
        this.decimalResolver = decimalResolver;
    }

    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }
}
