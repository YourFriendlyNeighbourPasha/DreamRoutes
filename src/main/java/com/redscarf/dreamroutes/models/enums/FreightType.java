package com.redscarf.dreamroutes.models.enums;

import java.math.BigDecimal;

public enum FreightType {
    SECURE(new BigDecimal("0.2")),
    DANGEROUS(new BigDecimal("0.5"));

    public final BigDecimal rate;

    FreightType(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return this.rate;
    }

}
