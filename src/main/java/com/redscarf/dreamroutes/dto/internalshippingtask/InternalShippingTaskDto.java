package com.redscarf.dreamroutes.dto.internalshippingtask;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalShippingTaskDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|23:26
 * @Version InternalShippingTaskDto: 1.0
 */

@Getter
@Setter
public class InternalShippingTaskDto {

    @NotBlank
    private String id;

    @NotBlank
    private String routeId;

    @NotBlank
    private String driverId;

    @NotBlank
    private String vehicleId;

    @NotBlank
    private String freightId;

    @NotBlank
    @Size(min = 20, max = 30)
    private String departureTime;

}
