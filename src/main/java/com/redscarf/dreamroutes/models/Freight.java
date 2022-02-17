package com.redscarf.dreamroutes.models;

import com.redscarf.dreamroutes.models.enums.FreightType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

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
public class Freight extends BaseModel {

    private double weight;

    private FreightType type;

    private String description;

}
