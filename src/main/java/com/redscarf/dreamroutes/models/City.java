package com.redscarf.dreamroutes.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.City
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 18.02.2022|00:35
 * @Version City: 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class City extends BaseSequenceModel {
    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false, updatable = false)
    private Region region;
}
