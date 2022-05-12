package com.redscarf.dreamroutes.dto.internalaccident;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalAccidentDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|23:54
 * @Version InternalAccidentDto: 1.0
 */

@Getter
@Setter
public class InternalAccidentDto {

    @NotBlank
    private String id;

    @NotNull
    private String description;

    @NotBlank
    @Size(min = 20, max = 30)
    private String happenedAt;

    @NotBlank
    private String internalShippingTaskReportId;

}
