package com.redscarf.dreamroutes.dto.freight;

import com.redscarf.dreamroutes.models.enums.FreightType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.FreightDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|03:09
 * @Version FreightDto: 1.0
 */

@Getter
@Setter
public class FreightDto {

    @NotBlank
    private String id;

    @Positive
    private double weight;

    @PositiveOrZero
    private FreightType type;

    @NotNull
    private String description;

}
