package com.redscarf.dreamroutes.dto.driver;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|02:58
 * @Version DriverCreateDto: 1.0
 */

@Getter
@Setter
public class DriverCreateDto {

    @NotBlank
    @Size(max = 75)
    private String firstName;

    @NotBlank
    @Size(max = 75)
    private String middleName;

    @NotBlank
    @Size(max = 75)
    private String lastName;

    @NotBlank
    @Size(min = 10, max = 10)
    private String birthday;

    @NotBlank
    @Size(min = 10, max = 10)
    private String employedOn;

}
