package com.redscarf.dreamroutes.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.Country
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 18.02.2022|00:35
 * @Version Country: 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Country extends BaseSequenceModel {

    private String name;

    private String code;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private List<Region> regions;

}
