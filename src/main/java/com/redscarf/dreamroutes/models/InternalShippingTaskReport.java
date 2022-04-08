package com.redscarf.dreamroutes.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.ZonedDateTime;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalShippingTaskReport
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 31.03.2022|22:40
 * @Version InternalShippingTaskReport: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class InternalShippingTaskReport extends BaseModel {

    @Column(columnDefinition = "TIMESTAMP")
    private ZonedDateTime destinationTime;

    @OneToOne
    @JoinColumn(name = "internal_shipping_task_id", nullable = false, updatable = false)
    private InternalShippingTask internalShippingTask;


}
