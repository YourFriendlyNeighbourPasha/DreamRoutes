package com.redscarf.dreamroutes.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.Salary
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 11.02.2022|02:16
 * @Version Salary: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Salary extends BaseModel {

    private BigDecimal cost;

    private BigDecimal bonusCost;

    @ManyToOne
    @JoinColumn(name = "driver_id", updatable = false, nullable = false)
    private Driver driver;

    //region Specific Constructor

    @Builder
    public Salary(UUID id, BigDecimal cost, BigDecimal bonusCost, Driver driver) {
        super(id);
        this.cost = cost;
        this.bonusCost = bonusCost;
        this.driver = driver;
    }

    //endregion

}
