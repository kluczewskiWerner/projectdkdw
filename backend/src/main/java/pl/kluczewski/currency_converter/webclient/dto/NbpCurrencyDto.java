package pl.kluczewski.currency_converter.webclient.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class NbpCurrencyDto {
    private String code;
    private RatesDto[] rates;

    public RatesDto[] getRates() {
        return rates;
    }

    public BigDecimal getMid() {
        return rates[0].getMid();
    }

    public String getEffectiveDate() {
        return rates[0].getEffectiveDate();
    }
}
