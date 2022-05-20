package com.redscarf.dreamroutes.dto.country;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.CountryCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|01:43
 * @Version CountryCreateDto: 1.0
 */

@Getter
@Setter
public class CountryCreateDto {

    @NotBlank
    @Size(max = 56)
    private String name;

    @NotBlank
    @Size(max = 3)
    private String code;

}
