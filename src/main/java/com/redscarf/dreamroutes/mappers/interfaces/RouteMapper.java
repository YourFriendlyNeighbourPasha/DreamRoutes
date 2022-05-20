package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.route.RouteCreateDto;
import com.redscarf.dreamroutes.dto.route.RouteDto;
import com.redscarf.dreamroutes.mappers.resolvers.UuidResolver;
import com.redscarf.dreamroutes.models.Route;
import com.redscarf.dreamroutes.services.interfaces.sequences.CityService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.RouteMapper
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 12.05.2022|03:38
 * @Version RouteMapper: 1.0
 */

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class RouteMapper
        implements GenericMapper<Route, RouteDto, RouteCreateDto> {

    protected CityService cityService;
    protected UuidResolver uuidResolver;

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromUUID(entity.getId()))")
    @Mapping(target = "firstCityId", source = "firstCity.id")
    @Mapping(target = "secondCityId", source = "secondCity.id")
    public abstract RouteDto fromEntityToDto(Route entity);

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromString(dto.getId()))")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "firstCity", expression = "java(cityService.findById(dto.getFirstCityId()))")
    @Mapping(target = "secondCity", expression = "java(cityService.findById(dto.getSecondCityId()))")
    public abstract Route fromDtoToEntity(RouteDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "firstCity", expression = "java(cityService.findById(createDto.getFirstCityId()))")
    @Mapping(target = "secondCity", expression = "java(cityService.findById(createDto.getSecondCityId()))")
    public abstract Route fromCreateDtoToEntity(RouteCreateDto createDto);

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @Autowired
    public void setUuidResolver(UuidResolver uuidResolver) {
        this.uuidResolver = uuidResolver;
    }
}
