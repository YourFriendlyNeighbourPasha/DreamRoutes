package com.redscarf.dreamroutes.models;

import com.redscarf.dreamroutes.models.enums.FreightType;
import lombok.*;

import javax.persistence.Entity;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.Freight
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 11.02.2022|01:30
 * @Version Freight: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Freight extends BaseModel {

    private double weight;

    private FreightType type;

    private String description;

    //region Specified Constructor

    @Builder
    public Freight(
            UUID id,
            double weight,
            FreightType type,
            String description
    ) {
        super(id);
        this.weight = weight;
        this.type = type;
        this.description = description;
    }

    //endregion

}
