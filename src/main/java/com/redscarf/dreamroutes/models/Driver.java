package com.redscarf.dreamroutes.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.Driver
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 11.02.2022|01:26
 * @Version Driver: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Driver extends BaseModel {

    private String firstName;

    private String middleName;

    private String lastName;

    @Column(columnDefinition = "DATE")
    private LocalDate birthday;

    @Column(columnDefinition = "DATE")
    private LocalDate employedOn;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "driver")
    private DriverLicense driverLicense;

    //region Specified Constructor

    @Builder
    public Driver(
            UUID id,
            String firstName,
            String middleName,
            String lastName,
            LocalDate birthday,
            LocalDate employedOn,
            DriverLicense driverLicense
    ) {
        super(id);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.employedOn = employedOn;
        this.driverLicense = driverLicense;
    }

    //endregion
}
