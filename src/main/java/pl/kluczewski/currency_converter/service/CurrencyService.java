package pl.kluczewski.currency_converter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kluczewski.currency_converter.model.AllCurrencyDto;
import pl.kluczewski.currency_converter.model.CurrencyDto;
import pl.kluczewski.currency_converter.webclient.CurrencyClient;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyClient currencyClient;

    public List<AllCurrencyDto> getAllValue() {
        return currencyClient.getValueForAllCurrency();
    }

    public CurrencyDto getValueFromPln(String currency, BigDecimal quantity) {
        return currencyClient.getValueFromPln(currency, quantity);
    }

    public CurrencyDto getValueFromPln(String currency, BigDecimal quantity, String date) {
        return currencyClient.getValueFromPln(currency, quantity, date);
    }

    public CurrencyDto getValueToPln(String currency, BigDecimal quantity) {
        return currencyClient.getValueFromPln(currency, quantity);
    }

    public CurrencyDto getValueToPln(String currency, BigDecimal quantity, String date) {
        return currencyClient.getValueToPln(currency, quantity, date);
    }
}
