package com.redscarf.dreamroutes.dto.internalshippingtaskreport;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalShippingTaskReportDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|23:42
 * @Version InternalShippingTaskReportDto: 1.0
 */

@Getter
@Setter
public class InternalShippingTaskReportDto {

    @NotBlank
    private String id;

    @NotBlank
    private String internalShippingTaskId;

    @NotBlank
    @Size(min = 20, max = 30)
    private String destinationTime;

}
