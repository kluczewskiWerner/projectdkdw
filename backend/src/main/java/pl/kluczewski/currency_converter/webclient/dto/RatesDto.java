package pl.kluczewski.currency_converter.webclient.dto;

import lombok.Getter;

import java.math.BigDecimal;


@Getter
public class RatesDto {
    private String no;
    private String effectiveDate;
    private BigDecimal mid;
}
