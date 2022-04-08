package com.redscarf.dreamroutes.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DriverLicenseCategory
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 18.02.2022|01:08
 * @Version DriverLicenseCategory: 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class DriverLicenseCategory extends BaseSequenceModel {

    private String code;

    @ManyToMany(mappedBy = "driverLicenseCategories")
    private List<DriverLicense> driverLicenses;

    //region Specified Constructor for Lombok @Builder

    @Builder
    public DriverLicenseCategory(Integer id, String code) {
        super(id);
        this.code = code;
    }

    //endregion

}
