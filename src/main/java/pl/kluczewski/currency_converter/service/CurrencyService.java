package pl.kluczewski.currency_converter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.kluczewski.currency_converter.model.AllCurrencyDto;
import pl.kluczewski.currency_converter.model.CurrencyDto;
import pl.kluczewski.currency_converter.model.entity.ConverterHistory;
import pl.kluczewski.currency_converter.webclient.CurrencyClient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyClient currencyClient;
    private final ConverterHistoryService converterHistoryService;

    public List<AllCurrencyDto> getAllValue() {
        return currencyClient.getValueForAllCurrency();
    }

    public CurrencyDto getValueFromPln(String currency, BigDecimal quantity) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CurrencyDto currencyDto = currencyClient.getValueFromPln(currency, quantity);

        converterHistoryService.addHistory(ConverterHistory.builder()
                .userEmail(auth.getName())
                .fromCurrencyCode(currency)
                .toCurrencyCode("PLN")
                .startValue(quantity)
                .convertedValue(currencyDto.getResult())
                .timeStamp(LocalDateTime.now())
                .build());
        return currencyDto;
    }

    public CurrencyDto getValueFromPln(String currency, BigDecimal quantity, String date) {
        return currencyClient.getValueFromPln(currency, quantity, date);
    }

    public CurrencyDto getValueToPln(String currency, BigDecimal quantity) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CurrencyDto currencyDto = currencyClient.getValueFromPln(currency, quantity);

        converterHistoryService.addHistory(ConverterHistory.builder()
                .userEmail(auth.getName())
                .fromCurrencyCode("PLN")
                .toCurrencyCode(currency)
                .startValue(quantity)
                .convertedValue(currencyDto.getResult())
                .timeStamp(LocalDateTime.now())
                .build());

        return currencyDto;
    }

    public CurrencyDto getValueToPln(String currency, BigDecimal quantity, String date) {
        return currencyClient.getValueToPln(currency, quantity, date);
    }
}
