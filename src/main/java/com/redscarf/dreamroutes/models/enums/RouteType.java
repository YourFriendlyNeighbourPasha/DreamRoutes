package com.redscarf.dreamroutes.models.enums;

import java.math.BigDecimal;

public enum RouteType {
    INTERNAL(new BigDecimal("15")),
    EXTERNAL(new BigDecimal("22"));

    private final BigDecimal rate;

    RouteType(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return this.rate;
    }

}
