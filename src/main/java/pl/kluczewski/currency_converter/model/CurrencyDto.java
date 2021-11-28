package pl.kluczewski.currency_converter.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;


@Builder
@Getter
public class CurrencyDto {
    String code;
    BigDecimal mid;
    BigDecimal result;
    String effectiveDate;
}
