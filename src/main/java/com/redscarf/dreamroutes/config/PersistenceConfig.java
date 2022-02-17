package com.redscarf.dreamroutes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.PersistenceConfig
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 16.02.2022|21:14
 * @Version PersistenceConfig: 1.0
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@EnableJpaAuditing
public class PersistenceConfig {
}
