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
 * dreamroutes.InternalAccident
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|00:58
 * @Version InternalAccident: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
public class InternalAccident extends BaseModel {

    private String description;

    @Column(columnDefinition = "TIMESTAMP")
    private ZonedDateTime happenedAt;

    @OneToOne
    @JoinColumn(name = "internal_ship_task_id", nullable = false, updatable = false)
    private InternalShippingTaskReport internalShippingTaskReport;

}