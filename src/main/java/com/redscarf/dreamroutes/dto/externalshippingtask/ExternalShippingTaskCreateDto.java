package com.redscarf.dreamroutes.dto.externalshippingtask;

import com.redscarf.dreamroutes.utils.validators.nonequalstrings.NonEqualFields;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalShippingTaskCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 06.05.2022|00:08
 * @Version ExternalShippingTaskCreateDto: 1.0
 */

@Getter
@Setter
@NonEqualFields(baseField = "driverId", matchField = "extraDriverId")
public class ExternalShippingTaskCreateDto {

    @NotBlank
    private String routeId;

    @NotBlank
    private String driverId;

    @NotBlank
    private String extraDriverId;

    @NotBlank
    private String vehicleId;

    @NotBlank
    private String freightId;

    @NotBlank
    @Size(min = 20, max = 30)
    private String departureTime;

}
