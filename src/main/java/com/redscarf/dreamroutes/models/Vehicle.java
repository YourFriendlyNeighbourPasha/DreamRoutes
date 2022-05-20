package com.redscarf.dreamroutes.models;

import lombok.*;

import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.Vehicle
 *
 * @Author: Pavel Shcherbatyi
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

}
