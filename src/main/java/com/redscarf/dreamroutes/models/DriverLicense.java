package com.redscarf.dreamroutes.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverLicense
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 18.02.2022|01:03
 * @Version DriverLicense: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class DriverLicense extends BaseModel {

    private long number;

    private int issuingAuthority;

    private LocalDate issuedAt;

    private LocalDate expirationDate;

    @OneToOne
    @JoinColumn(name = "driver_id", nullable = false, updatable = false)
    private Driver driver;

    @ManyToMany
    @JoinTable(
            name = "licenses_categories",
            joinColumns = @JoinColumn(name = "driver_license_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_license_category_id"))
    private List<DriverLicenseCategory> driverLicenseCategories;

}
