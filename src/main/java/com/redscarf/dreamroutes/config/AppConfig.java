package com.redscarf.dreamroutes.config;

import com.redscarf.dreamroutes.utils.SpringSecurityAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.PersistenceConfig
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 16.02.2022|21:14
 * @Version PersistenceConfig: 1.0
 */

@Configuration
public class AppConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new SpringSecurityAuditorAware();
    }

}
