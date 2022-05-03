package com.redscarf.dreamroutes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.BaseSequenceModel
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|04:10
 * @Version BaseSequenceModel: 1.0
 */

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseSequenceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
