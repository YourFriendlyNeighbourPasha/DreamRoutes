package com.redscarf.dreamroutes.dto.freight;

import com.redscarf.dreamroutes.models.enums.FreightType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.FreightCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|03:11
 * @Version FreightCreateDto: 1.0
 */

@Getter
@Setter
public class FreightCreateDto {

    @Positive
    private double weight;

    private FreightType type;

    @NotNull
    private String description;

}
