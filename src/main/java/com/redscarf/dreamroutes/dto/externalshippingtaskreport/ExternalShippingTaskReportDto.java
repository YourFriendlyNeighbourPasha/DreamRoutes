package com.redscarf.dreamroutes.dto.externalshippingtaskreport;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalShippingTaskReportDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 06.05.2022|00:08
 * @Version ExternalShippingTaskReportDto: 1.0
 */

@Getter
@Setter
public class ExternalShippingTaskReportDto {

    @NotBlank
    private String id;

    @NotBlank
    @Size(min = 20, max = 30)
    private String destinationTime;

    @NotBlank
    private String externalShippingTaskId;

}
