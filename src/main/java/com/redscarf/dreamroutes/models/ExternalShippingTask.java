package com.redscarf.dreamroutes.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ShippingTask
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 16.02.2022|21:41
 * @Version ShippingTask: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
public class ExternalShippingTask extends ShippingTask {

    @OneToOne
    @JoinColumn(name = "extra_driver_id", nullable = false, updatable = false)
    private Driver extraDriver;

}
