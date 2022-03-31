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
 * dreamroutes.ExternalShippingTaskReport
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|00:39
 * @Version ExternalShippingTaskReport: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
public class ExternalShippingTaskReport extends BaseModel {

    @Column(columnDefinition = "TIMESTAMP")
    private ZonedDateTime destinationTime;

    @OneToOne
    @JoinColumn(name = "external_shipping_task_id", nullable = false, updatable = false)
    private ExternalShippingTask externalShippingTask;

}