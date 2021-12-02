package pl.kluczewski.currency_converter.controller;

import pl.kluczewski.currency_converter.model.entity.ConverterHistory;
import pl.kluczewski.currency_converter.webclient.dto.ConverterHistoryDto;

import java.util.List;
import java.util.stream.Collectors;

public class ConverterHistoryDtoMapper {

    private ConverterHistoryDtoMapper() {}

    public static List<ConverterHistoryDto> mapToConverterHistoryDtos(List<ConverterHistory> converterHistories) {
        return converterHistories.stream()
                .map(ConverterHistoryDtoMapper::mapToConverterHistoryDto)
                .collect(Collectors.toList());
    }

    private static ConverterHistoryDto mapToConverterHistoryDto(ConverterHistory converterHistory) {
        return ConverterHistoryDto.builder()
                .fromCurrencyCode(converterHistory.getFromCurrencyCode())
                .toCurrencyCode(converterHistory.getToCurrencyCode())
                .startValue(converterHistory.getStartValue())
                .convertedValue(converterHistory.getConvertedValue())
                .timeStamp(converterHistory.getTimeStamp())
                .build();
    }
}
