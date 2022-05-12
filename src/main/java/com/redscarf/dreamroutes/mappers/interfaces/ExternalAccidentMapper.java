package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.externalaccident.ExternalAccidentCreateDto;
import com.redscarf.dreamroutes.dto.externalaccident.ExternalAccidentDto;
import com.redscarf.dreamroutes.mappers.resolvers.UuidResolver;
import com.redscarf.dreamroutes.models.ExternalAccident;
import com.redscarf.dreamroutes.services.interfaces.ExternalShippingTaskReportService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalAccidentMapper
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 13.05.2022|00:47
 * @Version ExternalAccidentMapper: 1.0
 */

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class ExternalAccidentMapper
        implements GenericMapper<ExternalAccident, ExternalAccidentDto, ExternalAccidentCreateDto> {

    protected UuidResolver uuidResolver;
    protected ExternalShippingTaskReportService externalShippingTaskReportService;

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromUUID(entity.getId()))")
    @Mapping(target = "externalShippingTaskReportId",
            expression = "java(uuidResolver.fromUUID(entity.getExternalShippingTaskReport().getId()))")
    public abstract ExternalAccidentDto fromEntityToDto(ExternalAccident entity);

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromString(dto.getId()))")
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "externalShippingTaskReport",
            expression = "java(externalShippingTaskReportService.findById(uuidResolver.fromString(dto.getExternalShippingTaskReportId())))")
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract ExternalAccident fromDtoToEntity(ExternalAccidentDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "externalShippingTaskReport",
            expression = "java(externalShippingTaskReportService.findById(uuidResolver.fromString(createDto.getExternalShippingTaskReportId())))")
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract ExternalAccident fromCreateDtoToEntity(ExternalAccidentCreateDto createDto);

    @Autowired
    public void setUuidResolver(UuidResolver uuidResolver) {
        this.uuidResolver = uuidResolver;
    }

    @Autowired
    public void setExternalShippingTaskReportService(ExternalShippingTaskReportService externalShippingTaskReportService) {
        this.externalShippingTaskReportService = externalShippingTaskReportService;
    }

}
