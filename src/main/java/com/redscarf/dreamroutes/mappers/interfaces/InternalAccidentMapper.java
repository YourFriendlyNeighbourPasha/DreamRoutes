package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.internalaccident.InternalAccidentCreateDto;
import com.redscarf.dreamroutes.dto.internalaccident.InternalAccidentDto;
import com.redscarf.dreamroutes.mappers.resolvers.UuidResolver;
import com.redscarf.dreamroutes.models.InternalAccident;
import com.redscarf.dreamroutes.services.interfaces.InternalShippingTaskReportService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalAccidentMapper
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 13.05.2022|00:10
 * @Version InternalAccidentMapper: 1.0
 */

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class InternalAccidentMapper
        implements GenericMapper<InternalAccident, InternalAccidentDto, InternalAccidentCreateDto> {

    protected UuidResolver uuidResolver;
    protected InternalShippingTaskReportService internalShippingTaskReportService;

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromUUID(entity.getId()))")
    @Mapping(target = "internalShippingTaskReportId",
             expression = "java(uuidResolver.fromUUID(entity.getInternalShippingTaskReport().getId()))")
    public abstract InternalAccidentDto fromEntityToDto(InternalAccident entity);

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromString(dto.getId()))")
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "internalShippingTaskReport",
             expression = "java(internalShippingTaskReportService.findById(uuidResolver.fromString(dto.getInternalShippingTaskReportId())))")
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract InternalAccident fromDtoToEntity(InternalAccidentDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "internalShippingTaskReport",
            expression = "java(internalShippingTaskReportService.findById(uuidResolver.fromString(createDto.getInternalShippingTaskReportId())))")
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract InternalAccident fromCreateDtoToEntity(InternalAccidentCreateDto createDto);

    @Autowired
    public void setUuidResolver(UuidResolver uuidResolver) {
        this.uuidResolver = uuidResolver;
    }

    @Autowired
    public void setInternalShippingTaskReportService(InternalShippingTaskReportService internalShippingTaskReportService) {
        this.internalShippingTaskReportService = internalShippingTaskReportService;
    }
}
