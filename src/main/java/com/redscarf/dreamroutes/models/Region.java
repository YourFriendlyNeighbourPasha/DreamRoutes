package com.redscarf.dreamroutes.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.Region
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 18.02.2022|00:35
 * @Version Region: 1.0
 */

@Entity
@Data
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, updatable = false)
    private Country country;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
    private List<City> cities;
}
