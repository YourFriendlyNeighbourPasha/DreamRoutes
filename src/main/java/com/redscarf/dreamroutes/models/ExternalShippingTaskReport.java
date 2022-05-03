package com.redscarf.dreamroutes.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

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
@NoArgsConstructor
public class ExternalShippingTaskReport extends BaseModel {

    private LocalDateTime destinationTime;

    @OneToOne
    @JoinColumn(name = "external_shipping_task_id", nullable = false, updatable = false)
    private ExternalShippingTask externalShippingTask;

}
