package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.driverlicensecategory.DriverLicenseCategoryCreateDto;
import com.redscarf.dreamroutes.dto.driverlicensecategory.DriverLicenseCategoryDto;
import com.redscarf.dreamroutes.models.DriverLicenseCategory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class DriverLicenseCategoryMapper
        implements GenericMapper<DriverLicenseCategory, DriverLicenseCategoryDto, DriverLicenseCategoryCreateDto> {

    @Override
    public abstract DriverLicenseCategoryDto fromEntityToDto(DriverLicenseCategory entity);

    @Override
    @Mapping(target = "driverLicenses", ignore = true)
    public abstract DriverLicenseCategory fromDtoToEntity(DriverLicenseCategoryDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "driverLicenses", ignore = true)
    public abstract DriverLicenseCategory fromCreateDtoToEntity(DriverLicenseCategoryCreateDto createDto);
}
