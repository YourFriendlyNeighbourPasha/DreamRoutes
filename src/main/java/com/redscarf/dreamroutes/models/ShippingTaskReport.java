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
 * dreamroutes.ShippingJobInfo
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 11.02.2022|01:27
 * @Version ShippingJobInfo: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
public class ShippingTaskReport extends BaseModel {

    @OneToOne
    @JoinColumn(name = "shipping_task_id", nullable = false, updatable = false)
    private ShippingTask shippingTask;

    @Column(columnDefinition = "TIMESTAMP")
    private ZonedDateTime destinationTime;

}
