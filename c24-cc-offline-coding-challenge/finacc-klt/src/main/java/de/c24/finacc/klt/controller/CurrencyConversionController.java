package de.c24.finacc.klt.controller;

import de.c24.finacc.klt.service.CurrencyConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    private final CurrencyConversionService currencyConversionService;

    public CurrencyConversionController(CurrencyConversionService currencyConversionService) {
        this.currencyConversionService = currencyConversionService;
    }

    @PostMapping("/convert")
    public ResponseEntity<BigDecimal> convertCurrency(@RequestBody Map<String, String> request) {
        String fromCurrency = request.get("fromCurrency");
        String toCurrency = request.get("toCurrency");
        BigDecimal amount = new BigDecimal(request.get("amount"));

        BigDecimal convertedAmount = currencyConversionService.convertCurrency(amount, fromCurrency, toCurrency);

        return ResponseEntity.ok(convertedAmount);
    }
}
