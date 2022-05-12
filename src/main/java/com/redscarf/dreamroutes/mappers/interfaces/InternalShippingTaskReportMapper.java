package com.redscarf.dreamroutes.mappers.interfaces;

import com.redscarf.dreamroutes.dto.internalshippingtaskreport.InternalShippingTaskReportCreateDto;
import com.redscarf.dreamroutes.dto.internalshippingtaskreport.InternalShippingTaskReportDto;
import com.redscarf.dreamroutes.mappers.resolvers.UuidResolver;
import com.redscarf.dreamroutes.models.InternalShippingTaskReport;
import com.redscarf.dreamroutes.services.interfaces.InternalShippingTaskService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalShippingTaskReportMapper
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 13.05.2022|00:04
 * @Version InternalShippingTaskReportMapper: 1.0
 */

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class InternalShippingTaskReportMapper
        implements GenericMapper<InternalShippingTaskReport,
        InternalShippingTaskReportDto, InternalShippingTaskReportCreateDto> {

    protected InternalShippingTaskService internalShippingTaskService;
    protected UuidResolver uuidResolver;


    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromUUID(entity.getId()))")
    @Mapping(target = "internalShippingTaskId",
             expression = "java(uuidResolver.fromUUID(entity.getInternalShippingTask().getId()))")
    public abstract InternalShippingTaskReportDto fromEntityToDto(InternalShippingTaskReport entity);

    @Override
    @Mapping(target = "id", expression = "java(uuidResolver.fromString(dto.getId()))")
    @Mapping(target = "internalShippingTask",
            expression = "java(internalShippingTaskService.findById(uuidResolver.fromString(dto.getInternalShippingTaskId())))")
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract InternalShippingTaskReport fromDtoToEntity(InternalShippingTaskReportDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "internalShippingTask",
            expression = "java(internalShippingTaskService.findById(uuidResolver.fromString(createDto.getInternalShippingTaskId())))")
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract InternalShippingTaskReport fromCreateDtoToEntity(InternalShippingTaskReportCreateDto createDto);

    @Autowired
    public void setInternalShippingTaskService(InternalShippingTaskService internalShippingTaskService) {
        this.internalShippingTaskService = internalShippingTaskService;
    }

    @Autowired
    public void setUuidResolver(UuidResolver uuidResolver) {
        this.uuidResolver = uuidResolver;
    }
}
