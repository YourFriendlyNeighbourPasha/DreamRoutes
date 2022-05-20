package com.redscarf.dreamroutes.dto.country;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.CountryUpdateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|02:05
 * @Version CountryUpdateDto: 1.0
 */

@Getter
@Setter
public class CountryDto {

    @Positive
    private Integer id;

    @NotBlank
    @Size(max = 56)
    private String name;

    @NotBlank
    @Size(max = 3)
    private String code;

}
