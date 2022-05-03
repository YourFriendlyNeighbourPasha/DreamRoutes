package com.redscarf.dreamroutes.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
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
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    //@CreatedBy
    //@Column(updatable = false)
    //protected String createdBy;

    @CreatedDate
    @Column(updatable = false)
    protected LocalDateTime createdAt;

    //@LastModifiedBy
    //protected String modifiedBy;

    @LastModifiedDate
    protected LocalDateTime modifiedAt;

}
