package com.redscarf.dreamroutes.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.BaseSequenceModel
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 01.04.2022|04:10
 * @Version BaseSequenceModel: 1.0
 */

@MappedSuperclass
@Data
@EqualsAndHashCode
@ToString
public abstract class BaseSequenceModel implements Serializable {

    @Id
    @ReadOnlyProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
