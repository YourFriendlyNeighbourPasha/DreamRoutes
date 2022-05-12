package com.redscarf.dreamroutes.dto.externalshippingtaskreport;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalShippingTaskReportCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 06.05.2022|00:17
 * @Version ExternalShippingTaskReportCreateDto: 1.0
 */

@Getter
@Setter
public class ExternalShippingTaskReportCreateDto {

    @NotBlank
    @Size(min = 20, max = 30)
    private String destinationTime;

    @NotBlank
    private String externalShippingTaskId;

}
