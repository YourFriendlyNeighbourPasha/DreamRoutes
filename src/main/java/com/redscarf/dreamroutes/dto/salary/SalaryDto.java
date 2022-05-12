package com.redscarf.dreamroutes.dto.salary;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.SalaryDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|03:23
 * @Version SalaryDto: 1.0
 */

@Getter
@Setter
public class SalaryDto {

    @NotBlank
    private String id;

    @NotBlank
    private BigDecimal cost;

    @NotBlank
    private BigDecimal bonusCost;

    @NotBlank
    private String driverId;

}
