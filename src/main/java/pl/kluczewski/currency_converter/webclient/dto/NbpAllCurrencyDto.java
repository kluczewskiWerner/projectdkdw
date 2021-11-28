package pl.kluczewski.currency_converter.webclient.dto;

import lombok.Getter;

@Getter
public class NbpAllCurrencyDto {
    private AllRatesDto[] rates;
    private String effectiveDate;
}
