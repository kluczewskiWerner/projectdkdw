package pl.kluczewski.currency_converter.webclient.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class ConverterHistoryDto {
    private String fromCurrencyCode;
    private String toCurrencyCode;
    private BigDecimal startValue;
    private BigDecimal convertedValue;
    private LocalDateTime timeStamp;
}
