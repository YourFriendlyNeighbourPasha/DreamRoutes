package com.redscarf.dreamroutes.dto.driverlicensecategory;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverLicenseCategoryCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|02:43
 * @Version DriverLicenseCategoryCreateDto: 1.0
 */

@Getter
@Setter
public class DriverLicenseCategoryCreateDto {

    @NotBlank
    @Size(min = 1, max = 5)
    private String code;

}
