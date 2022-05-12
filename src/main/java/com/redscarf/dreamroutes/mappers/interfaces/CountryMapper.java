package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.country.CountryCreateDto;
import com.redscarf.dreamroutes.dto.country.CountryDto;
import com.redscarf.dreamroutes.models.Country;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class CountryMapper implements GenericMapper<Country, CountryDto, CountryCreateDto> {

    @Override
    public abstract CountryDto fromEntityToDto(Country entity);

    @Override
    @Mapping(target = "regions", ignore = true)
    public abstract Country fromDtoToEntity(CountryDto dto);

    @Override
    @Mapping(target = "regions", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract Country fromCreateDtoToEntity(CountryCreateDto createDto);
}
