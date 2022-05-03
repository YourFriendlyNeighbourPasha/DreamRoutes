package com.redscarf.dreamroutes.models;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ShippingTask
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 16.02.2022|21:41
 * @Version ExternalShippingTask: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class ExternalShippingTask extends BaseModel {

    @OneToOne
    @JoinColumn(name = "route_id", nullable = false, updatable = false)
    private Route route;

    @OneToOne
    @JoinColumn(name = "driver_id", nullable = false, updatable = false)
    private Driver driver;

    @OneToOne
    @JoinColumn(name = "extra_driver_id", nullable = false, updatable = false)
    private Driver extraDriver;

    @OneToOne
    @JoinColumn(name = "vehicle_id", nullable = false, updatable = false)
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "freight_id", nullable = false, updatable = false)
    private Freight freight;

    private LocalDateTime departureTime;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "externalShippingTask")
    private ExternalShippingTaskReport shippingTaskReport;

}
