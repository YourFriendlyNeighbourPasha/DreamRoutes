package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.region.RegionCreateDto;
import com.redscarf.dreamroutes.dto.region.RegionDto;
import com.redscarf.dreamroutes.models.Region;
import com.redscarf.dreamroutes.services.interfaces.sequences.CountryService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public abstract class RegionMapper implements GenericMapper<Region, RegionDto, RegionCreateDto> {

    protected CountryService countryService;

    @Override
    @Mapping(source = "country.id", target = "countryId")
    public abstract RegionDto fromEntityToDto(Region entity);

    @Override
    @Mappings({
            @Mapping(target = "cities", ignore = true),
            @Mapping(target = "country", expression = "java(countryService.findById(dto.getCountryId()))")
    })
    public abstract Region fromDtoToEntity(RegionDto dto);

    @Override
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "cities", ignore = true),
            @Mapping(target = "country", expression = "java(countryService.findById(createDto.getCountryId()))")
    })
    public abstract Region fromCreateDtoToEntity(RegionCreateDto createDto);

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }
}
