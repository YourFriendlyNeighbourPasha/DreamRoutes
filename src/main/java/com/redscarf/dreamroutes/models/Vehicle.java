package com.redscarf.dreamroutes.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

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
public class Vehicle extends BaseModel {

    private String manufacturerTitle;

    private String model;

    private String vehicleCode;

    private double weightCapacity;

}
