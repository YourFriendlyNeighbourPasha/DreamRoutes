package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.city.CityCreateDto;
import com.redscarf.dreamroutes.dto.city.CityDto;
import com.redscarf.dreamroutes.models.City;
import com.redscarf.dreamroutes.services.interfaces.sequences.RegionService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class CityMapper implements GenericMapper<City, CityDto, CityCreateDto> {

    protected RegionService regionService;

    @Override
    @Mapping(target = "regionId", source = "region.id")
    public abstract CityDto fromEntityToDto(City entity);

    @Override
    @Mapping(target = "region", expression = "java(regionService.findById(dto.getRegionId()))")
    public abstract City fromDtoToEntity(CityDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "region", expression = "java(regionService.findById(createDto.getRegionId()))")
    public abstract City fromCreateDtoToEntity(CityCreateDto createDto);

    @Autowired
    public void setRegionService(RegionService regionService) {
        this.regionService = regionService;
    }
}
