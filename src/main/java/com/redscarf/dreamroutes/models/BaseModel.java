package com.redscarf.dreamroutes.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.BaseModel
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 16.02.2022|19:36
 * @Version BaseModel: 1.0
 */

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP")
    private ZonedDateTime createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "TIMESTAMP")
    private ZonedDateTime modifiedAt;

    //region Contructors

    public BaseModel() {
    }

    public BaseModel(UUID id) {
        this.id = id;
    }

    //endregion

}
