package pl.kluczewski.currency_converter.model;

import lombok.Builder;
import lombok.Getter;
import pl.kluczewski.currency_converter.webclient.dto.AllRatesDto;

@Builder
@Getter
public class AllCurrencyDto {
    private final AllRatesDto[] rates;
    private final String base;
    private final String effectiveDate;
}
