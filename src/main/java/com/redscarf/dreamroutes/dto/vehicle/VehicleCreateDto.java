package com.redscarf.dreamroutes.dto.vehicle;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.VehicleCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|03:12
 * @Version VehicleCreateDto: 1.0
 */

@Getter
@Setter
public class VehicleCreateDto {

    @NotBlank
    @Size(max = 50)
    private String manufacturerTitle;

    @NotBlank
    @Size(max = 20)
    private String model;

    @NotBlank
    @Size(max = 25)
    private String vehicleCode;

    @Positive
    private double weightCapacity;

}
