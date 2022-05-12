package com.redscarf.dreamroutes.dto.region;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.RegionCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|02:33
 * @Version RegionCreateDto: 1.0
 */

@Getter
@Setter
public class RegionCreateDto {

    @NotBlank
    @Size(max = 150)
    private String name;

    @Positive
    private Integer countryId;

}
