package com.redscarf.dreamroutes.dto.salary;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.SalaryCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|03:32
 * @Version SalaryCreateDto: 1.0
 */

@Getter
@Setter
public class SalaryCreateDto {

    @NotBlank
    private String cost;

    @NotBlank
    private String bonusCost;

    @NotBlank
    private String driverId;

}
