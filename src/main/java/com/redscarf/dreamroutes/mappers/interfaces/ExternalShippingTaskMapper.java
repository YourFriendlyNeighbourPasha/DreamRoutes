package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.externalshippingtask.ExternalShippingTaskCreateDto;
import com.redscarf.dreamroutes.dto.externalshippingtask.ExternalShippingTaskDto;
import com.redscarf.dreamroutes.mappers.resolvers.UuidResolver;
import com.redscarf.dreamroutes.models.ExternalShippingTask;
import com.redscarf.dreamroutes.services.interfaces.DriverService;
import com.redscarf.dreamroutes.services.interfaces.FreightService;
import com.redscarf.dreamroutes.services.interfaces.RouteService;
import com.redscarf.dreamroutes.services.interfaces.VehicleService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalShippingTaskMapper
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 13.05.2022|00:39
 * @Version ExternalShippingTaskMapper: 1.0
 */

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class ExternalShippingTaskMapper
        implements GenericMapper<ExternalShippingTask, ExternalShippingTaskDto, ExternalShippingTaskCreateDto> {

    protected RouteService routeService;
    protected DriverService driverService;
    protected VehicleService vehicleService;
    protected FreightService freightService;
    protected UuidResolver uuidResolver;

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromUUID(entity.getId()))")
    @Mapping(target = "vehicleId", expression = "java(uuidResolver.fromUUID(entity.getVehicle().getId()))")
    @Mapping(target = "routeId", expression = "java(uuidResolver.fromUUID(entity.getRoute().getId()))")
    @Mapping(target = "freightId", expression = "java(uuidResolver.fromUUID(entity.getFreight().getId()))")
    @Mapping(target = "driverId", expression = "java(uuidResolver.fromUUID(entity.getDriver().getId()))")
    @Mapping(target = "extraDriverId", expression = "java(uuidResolver.fromUUID(entity.getExtraDriver().getId()))")
    public abstract ExternalShippingTaskDto fromEntityToDto(ExternalShippingTask entity);

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromString(dto.getId()))")
    @Mapping(target = "vehicle", expression = "java(vehicleService.findById(uuidResolver.fromString(dto.getVehicleId())))")
    @Mapping(target = "route", expression = "java(routeService.findById(uuidResolver.fromString(dto.getRouteId())))")
    @Mapping(target = "freight", expression = "java(freightService.findById(uuidResolver.fromString(dto.getFreightId())))")
    @Mapping(target = "driver", expression = "java(driverService.findById(uuidResolver.fromString(dto.getDriverId())))")
    @Mapping(target = "extraDriver", expression = "java(driverService.findById(uuidResolver.fromString(dto.getExtraDriverId())))")
    @Mapping(target = "shippingTaskReport", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract ExternalShippingTask fromDtoToEntity(ExternalShippingTaskDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vehicle", expression = "java(vehicleService.findById(uuidResolver.fromString(createDto.getVehicleId())))")
    @Mapping(target = "route", expression = "java(routeService.findById(uuidResolver.fromString(createDto.getRouteId())))")
    @Mapping(target = "freight", expression = "java(freightService.findById(uuidResolver.fromString(createDto.getFreightId())))")
    @Mapping(target = "driver", expression = "java(driverService.findById(uuidResolver.fromString(createDto.getDriverId())))")
    @Mapping(target = "extraDriver", expression = "java(driverService.findById(uuidResolver.fromString(createDto.getExtraDriverId())))")
    @Mapping(target = "shippingTaskReport", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract ExternalShippingTask fromCreateDtoToEntity(ExternalShippingTaskCreateDto createDto);

    @Autowired
    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }

    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    @Autowired
    public void setVehicleService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Autowired
    public void setFreightService(FreightService freightService) {
        this.freightService = freightService;
    }

    @Autowired
    public void setUuidResolver(UuidResolver uuidResolver) {
        this.uuidResolver = uuidResolver;
    }

}
