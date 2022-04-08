package com.redscarf.dreamroutes.models;

import com.redscarf.dreamroutes.models.enums.RouteType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.Route
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 11.02.2022|01:12
 * @Version Route: 1.0
 */

@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Route extends BaseModel {

    private String title;

    private float distance;

    private RouteType type;

    @ManyToOne
    @JoinColumn(name = "first_city_id", nullable = false, updatable = false)
    private City firstCity;

    @ManyToOne
    @JoinColumn(name = "second_city_id", nullable = false, updatable = false)
    private City secondCity;

    private long estimatedTime;

    //region Specific Constructor

    @Builder
    public Route(
            UUID id,
            String title,
            float distance,
            RouteType type,
            City firstCity,
            City secondCity,
            long estimatedTime
    ) {
        super(id);
        this.title = title;
        this.distance = distance;
        this.type = type;
        this.firstCity = firstCity;
        this.secondCity = secondCity;
        this.estimatedTime = estimatedTime;
    }

    //endregion

}
