package com.redscarf.dreamroutes.dto.city;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.CityDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|02:37
 * @Version CityDto: 1.0
 */

@Getter
@Setter
public class CityDto {

    @Positive
    private Integer id;

    @NotBlank
    @Size(max = 85)
    private String name;

    @Positive
    private Integer regionId;

}
