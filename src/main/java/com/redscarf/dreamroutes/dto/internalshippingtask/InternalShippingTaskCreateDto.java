package com.redscarf.dreamroutes.dto.internalshippingtask;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalShippingTaskCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|23:41
 * @Version InternalShippingTaskCreateDto: 1.0
 */

@Getter
@Setter
public class InternalShippingTaskCreateDto {

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
