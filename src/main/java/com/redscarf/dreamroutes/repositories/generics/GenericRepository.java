package com.redscarf.dreamroutes.repositories.generics;

import com.redscarf.dreamroutes.models.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface GenericRepository<T extends BaseModel> extends JpaRepository<T, UUID> {
}