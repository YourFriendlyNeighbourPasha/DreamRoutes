package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.externalshippingtaskreport.ExternalShippingTaskReportCreateDto;
import com.redscarf.dreamroutes.dto.externalshippingtaskreport.ExternalShippingTaskReportDto;
import com.redscarf.dreamroutes.mappers.resolvers.UuidResolver;
import com.redscarf.dreamroutes.models.ExternalShippingTaskReport;
import com.redscarf.dreamroutes.services.interfaces.ExternalShippingTaskService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalShippingTaskReportMapper
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 13.05.2022|00:43
 * @Version ExternalShippingTaskReportMapper: 1.0
 */

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class ExternalShippingTaskReportMapper
        implements GenericMapper<ExternalShippingTaskReport,
        ExternalShippingTaskReportDto, ExternalShippingTaskReportCreateDto> {

    protected ExternalShippingTaskService externalShippingTaskService;
    protected UuidResolver uuidResolver;

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromUUID(entity.getId()))")
    @Mapping(target = "externalShippingTaskId",
            expression = "java(uuidResolver.fromUUID(entity.getExternalShippingTask().getId()))")
    public abstract ExternalShippingTaskReportDto fromEntityToDto(ExternalShippingTaskReport entity);

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromString(dto.getId()))")
    @Mapping(target = "externalShippingTask",
            expression = "java(externalShippingTaskService.findById(uuidResolver.fromString(dto.getExternalShippingTaskId())))")
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract ExternalShippingTaskReport fromDtoToEntity(ExternalShippingTaskReportDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalShippingTask",
            expression = "java(externalShippingTaskService.findById(uuidResolver.fromString(createDto.getExternalShippingTaskId())))")
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract ExternalShippingTaskReport fromCreateDtoToEntity(ExternalShippingTaskReportCreateDto createDto);

    @Autowired
    public void setExternalShippingTaskService(ExternalShippingTaskService externalShippingTaskService) {
        this.externalShippingTaskService = externalShippingTaskService;
    }

    @Autowired
    public void setUuidResolver(UuidResolver uuidResolver) {
        this.uuidResolver = uuidResolver;
    }

}
