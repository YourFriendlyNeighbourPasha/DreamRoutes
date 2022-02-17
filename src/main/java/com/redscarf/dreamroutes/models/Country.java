package com.redscarf.dreamroutes.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.Country
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 18.02.2022|00:35
 * @Version Country: 1.0
 */

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String name;

    private String code;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private List<Region> regions;
}
