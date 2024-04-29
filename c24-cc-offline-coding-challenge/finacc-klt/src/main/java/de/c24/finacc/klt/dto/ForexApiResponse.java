package de.c24.finacc.klt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Map;

public class ForexApiResponse {
    private String base;
    private Map<String, BigDecimal> rates;

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    @JsonProperty("rates")
    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }
}