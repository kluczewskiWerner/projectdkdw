package pl.kluczewski.currency_converter.webclient.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AllRatesDto {
    private String currency;
    private String code;
    private BigDecimal mid;
}
