package com.redscarf.dreamroutes.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.time.LocalDate;

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

}
