package com.redscarf.dreamroutes.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.Region
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 18.02.2022|00:35
 * @Version Region: 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Region extends BaseSequenceModel {

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, updatable = false)
    private Country country;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
    private List<City> cities;

}
