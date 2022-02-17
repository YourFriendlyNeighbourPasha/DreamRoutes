package com.redscarf.dreamroutes.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverLicenseCategory
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 18.02.2022|01:08
 * @Version DriverLicenseCategory: 1.0
 */

@Entity
@Data
public class DriverLicenseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    private String code;

    @ManyToMany(mappedBy = "driverLicenseCategories")
    private List<DriverLicense> driverLicenses;

}
