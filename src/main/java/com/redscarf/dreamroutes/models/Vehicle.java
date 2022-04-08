package com.redscarf.dreamroutes.models;

import lombok.*;

import javax.persistence.Entity;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.Vehicle
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 11.02.2022|01:26
 * @Version Vehicle: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Vehicle extends BaseModel {

    private String manufacturerTitle;

    private String model;

    private String vehicleCode;

    private double weightCapacity;

    //region Specific Constructor

    @Builder
    public Vehicle(
            UUID id,
            String manufacturerTitle,
            String model,
            String vehicleCode,
            double weightCapacity
    ) {
        super(id);
        this.manufacturerTitle = manufacturerTitle;
        this.model = model;
        this.vehicleCode = vehicleCode;
        this.weightCapacity = weightCapacity;
    }

    //endregion

}
