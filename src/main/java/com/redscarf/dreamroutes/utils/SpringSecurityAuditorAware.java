package com.redscarf.dreamroutes.utils;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.SpringSecurityAuditorAware
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 05.05.2022|23:01
 * @Version SpringSecurityAuditorAware: 1.0
 */

public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Admin").filter(s -> !s.isEmpty());
    }

}
