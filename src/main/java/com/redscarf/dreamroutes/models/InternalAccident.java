package com.redscarf.dreamroutes.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.InternalAccident
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|00:58
 * @Version InternalAccident: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class InternalAccident extends BaseModel {

    private String description;

    private LocalDateTime happenedAt;

    private BigDecimal penalty;

    @OneToOne
    @JoinColumn(name = "internal_ship_task_id", nullable = false, updatable = false)
    private InternalShippingTaskReport internalShippingTaskReport;

}
