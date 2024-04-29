package de.c24.finacc.klt.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.c24.finacc.klt.HttpClient;
import de.c24.finacc.klt.dto.ForexApiResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
public class CurrencyConversionService {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private Map<String, BigDecimal> currencyRates;

    public CurrencyConversionService(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public BigDecimal convertCurrency(BigDecimal amount, String fromCurrency, String toCurrency) {

        Map<String, BigDecimal> currencyRates = fetchAndProcessCurrencyRates();


        if (!currencyRates.containsKey(fromCurrency) || !currencyRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency pair. Please provide valid currencies to allow conversion.");
        }
        BigDecimal fromRate = currencyRates.get(fromCurrency);
        BigDecimal toRate = currencyRates.get(toCurrency);
        BigDecimal convertedAmount = amount.multiply(toRate).divide(fromRate, 2, RoundingMode.HALF_UP);

        return convertedAmount;
    }

    @Cacheable("currencyRates")
    private Map<String, BigDecimal> fetchAndProcessCurrencyRates() {
        String response = httpClient.get("http://localhost:9090/forex/currencies");
        return parseCurrencyRates(response);
    }

    private Map<String, BigDecimal> parseCurrencyRates(String response) {
        try {
            ForexApiResponse forexApiResponse = objectMapper.readValue(response, ForexApiResponse.class);
            return forexApiResponse.getRates();
        } catch (IOException e) {
            throw new RuntimeException("Error parsing currency conversion API response.", e);
        }
    }
}
