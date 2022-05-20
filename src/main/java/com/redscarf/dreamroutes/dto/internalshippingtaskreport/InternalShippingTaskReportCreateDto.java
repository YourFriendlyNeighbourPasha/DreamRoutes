package com.redscarf.dreamroutes.dto.internalshippingtaskreport;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalShippingTaskReportCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|23:46
 * @Version InternalShippingTaskReportCreateDto: 1.0
 */

@Getter
@Setter
public class InternalShippingTaskReportCreateDto {

    @NotBlank
    private String internalShippingTaskId;

    @NotBlank
    @Size(min = 20, max = 30)
    private String destinationTime;

}
