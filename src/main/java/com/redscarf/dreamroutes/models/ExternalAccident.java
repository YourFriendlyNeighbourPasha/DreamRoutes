package com.redscarf.dreamroutes.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.ExternalAccident
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|00:58
 * @Version ExternalAccident: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class ExternalAccident extends BaseModel {

    private String description;

    @Column(columnDefinition = "TIMESTAMP")
    private ZonedDateTime happenedAt;

    @OneToOne
    @JoinColumn(name = "external_ship_task_id", nullable = false, updatable = false)
    private ExternalShippingTaskReport externalShippingTaskReport;

    //region Specific Constructor

    @Builder
    public ExternalAccident(
            UUID id,
            String description,
            ZonedDateTime happenedAt,
            ExternalShippingTaskReport externalShippingTaskReport
    ) {
        super(id);
        this.description = description;
        this.happenedAt = happenedAt;
        this.externalShippingTaskReport = externalShippingTaskReport;
    }

    //endregion

}
