package com.redscarf.dreamroutes.dto.route;

import com.redscarf.dreamroutes.models.enums.RouteType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.RouteCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|03:08
 * @Version RouteCreateDto: 1.0
 */

@Getter
@Setter
public class RouteCreateDto {

    @NotBlank
    @Size(max = 50)
    private String title;

    @Positive
    private float distance;

    private RouteType type;

    @Positive
    private Integer firstCityId;

    @Positive
    private Integer secondCityId;

    @Positive
    private long estimatedTime;

}
