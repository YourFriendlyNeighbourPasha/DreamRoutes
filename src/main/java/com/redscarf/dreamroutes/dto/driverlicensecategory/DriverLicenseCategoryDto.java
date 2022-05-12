package com.redscarf.dreamroutes.dto.driverlicensecategory;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverLicenseCategoryDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|02:41
 * @Version DriverLicenseCategoryDto: 1.0
 */

@Getter
@Setter
public class DriverLicenseCategoryDto {

    @Positive
    private Integer id;

    @NotBlank
    @Size(max = 5)
    private String code;

}
