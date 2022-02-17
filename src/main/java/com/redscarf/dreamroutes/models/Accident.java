package com.redscarf.dreamroutes.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.ZonedDateTime;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.Accident
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 16.02.2022|21:53
 * @Version Accident: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
public class Accident extends BaseModel {

    @OneToOne
    @JoinColumn(name = "origin_ship_task_id", nullable = false, updatable = false)
    private ShippingTaskReport shippingTaskReport;

    private String description;

    @Column(columnDefinition = "TIMESTAMP")
    private ZonedDateTime happenedAt;

}
