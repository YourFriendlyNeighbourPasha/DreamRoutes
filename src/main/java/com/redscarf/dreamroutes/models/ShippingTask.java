package com.redscarf.dreamroutes.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ShippingTask
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 16.02.2022|19:51
 * @Version ShippingTask: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ShippingTask extends BaseModel {

    @OneToOne
    @JoinColumn(name = "route_id", nullable = false, updatable = false)
    private Route route;

    @OneToOne
    @JoinColumn(name = "driver_id", nullable = false, updatable = false)
    private Driver driver;

    @OneToOne
    @JoinColumn(name = "vehicle_id", nullable = false, updatable = false)
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "freight_id", nullable = false, updatable = false)
    private Freight freight;

    @Column(columnDefinition = "TIMESTAMP")
    private ZonedDateTime departureTime;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "shippingTask")
    private ShippingTaskReport shippingTaskReport;

}
