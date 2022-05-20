package com.redscarf.dreamroutes.dto.internalaccident;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalAccidentCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 06.05.2022|00:02
 * @Version InternalAccidentCreateDto: 1.0
 */

@Getter
@Setter
public class InternalAccidentCreateDto {

    @NotNull
    private String description;

    @NotBlank
    @Size(min = 20, max = 30)
    private String happenedAt;

    @NotBlank
    private String penalty;

    @NotBlank
    private String internalShippingTaskReportId;

}
