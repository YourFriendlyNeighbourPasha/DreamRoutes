package com.redscarf.dreamroutes.repositories.generics;

import com.redscarf.dreamroutes.models.BaseSequenceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericSequenceRepository<T extends BaseSequenceModel>
        extends JpaRepository<T, Integer> {
}
