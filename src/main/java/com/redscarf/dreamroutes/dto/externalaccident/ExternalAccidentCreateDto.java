package com.redscarf.dreamroutes.dto.externalaccident;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalAccidentCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 06.05.2022|00:25
 * @Version ExternalAccidentCreateDto: 1.0
 */

@Getter
@Setter
public class ExternalAccidentCreateDto {

    @NotBlank
    @Size(max = 300)
    private String description;

    @NotBlank
    @Size(min = 20, max = 30)
    private String happenedAt;

    @NotBlank
    private String externalShippingTaskReportId;

}
