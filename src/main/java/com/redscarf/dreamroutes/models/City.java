package com.redscarf.dreamroutes.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.City
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 18.02.2022|00:35
 * @Version City: 1.0
 */

@Entity
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false, updatable = false)
    private Region region;

}
