package com.redscarf.dreamroutes.mappers.resolvers;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.DecimalResolver
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 12.05.2022|03:58
 * @Version DecimalResolver: 1.0
 */

@Component
public class DecimalResolver {

    public BigDecimal fromString(String value) {
        if(value != null) {
            return !value.isBlank() || !value.isEmpty() ? new BigDecimal(value) : new BigDecimal(0);
        }

        return null;
    }

    public String fromDecimal(BigDecimal value) {
        return value != null ? value.toString() : null;
    }

}
