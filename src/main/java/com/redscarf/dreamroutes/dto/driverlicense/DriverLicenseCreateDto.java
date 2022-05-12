package com.redscarf.dreamroutes.dto.driverlicense;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverLicenseCreateDto
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|03:17
 * @Version DriverLicenseCreateDto: 1.0
 */

@Getter
@Setter
public class DriverLicenseCreateDto {

    @Positive
    private long number;

    @Positive
    private int issuingAuthority;

    @NotBlank
    @Size(min = 10, max = 10)
    private String issuedAt;

    @NotBlank
    @Size(min = 10, max = 10)
    private String expirationDate;

    @NotBlank
    private String driverId;

}
