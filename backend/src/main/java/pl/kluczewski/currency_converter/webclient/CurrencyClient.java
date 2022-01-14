package pl.kluczewski.currency_converter.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.kluczewski.currency_converter.converter.Convert;
import pl.kluczewski.currency_converter.model.AllCurrencyDto;
import pl.kluczewski.currency_converter.model.CurrencyDto;
import pl.kluczewski.currency_converter.webclient.dto.NbpAllCurrencyDto;
import pl.kluczewski.currency_converter.webclient.dto.NbpCurrencyDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Component
public class CurrencyClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final Convert convert = new Convert();

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(url, responseType, objects);
    }

    public List<AllCurrencyDto> getValueForAllCurrency() {
        NbpAllCurrencyDto nbpAllCurrencyDto = callGetMethod("http://api.nbp.pl/api/exchangerates/tables/A",
                NbpAllCurrencyDto[].class)[0];

        List<AllCurrencyDto> allCurrencyDto = new ArrayList<>();
        allCurrencyDto.add(
                AllCurrencyDto.builder()
                        .rates(nbpAllCurrencyDto.getRates())
                        .base("PLN")
                        .effectiveDate(nbpAllCurrencyDto.getEffectiveDate())
                        .build()
        );

        return allCurrencyDto;
    }

    public CurrencyDto getValueFromPln(String currency, BigDecimal quantity) {
        NbpCurrencyDto nbpCurrencyDto = callGetMethod("http://api.nbp.pl/api/exchangerates/rates/a/{currency}/",
                NbpCurrencyDto.class, currency);

        return CurrencyDto.builder()
                .code(nbpCurrencyDto.getCode())
                .mid(nbpCurrencyDto.getMid())
                .result(convert.fromPln(quantity, nbpCurrencyDto.getMid()))
                .effectiveDate(nbpCurrencyDto.getEffectiveDate())
                .build();
    }

    public CurrencyDto getValueFromPln(String currency, BigDecimal quantity, String date) {
        NbpCurrencyDto nbpCurrencyDto = callGetMethod("http://api.nbp.pl/api/exchangerates/rates/a/{currency}/{date}/",
                NbpCurrencyDto.class, currency, date);

        return CurrencyDto.builder()
                .code(nbpCurrencyDto.getCode())
                .mid(nbpCurrencyDto.getMid())
                .result(convert.fromPln(quantity, nbpCurrencyDto.getMid()))
                .effectiveDate(nbpCurrencyDto.getEffectiveDate())
                .build();
    }

    public CurrencyDto getValueToPln(String currency, BigDecimal quantity) {
        NbpCurrencyDto nbpCurrencyDto = callGetMethod("http://api.nbp.pl/api/exchangerates/rates/a/{currency}/",
                NbpCurrencyDto.class, currency);

        return CurrencyDto.builder()
                .mid(nbpCurrencyDto.getMid())
                .result(convert.toPln(quantity, nbpCurrencyDto.getMid()))
                .effectiveDate(nbpCurrencyDto.getEffectiveDate())
                .build();
    }

    public CurrencyDto getValueToPln(String currency, BigDecimal quantity, String date) {
        NbpCurrencyDto nbpCurrencyDto = callGetMethod("http://api.nbp.pl/api/exchangerates/rates/a/{currency}/{date}/",
                NbpCurrencyDto.class, currency, date);

        return CurrencyDto.builder()
                .mid(nbpCurrencyDto.getMid())
                .result(convert.toPln(quantity, nbpCurrencyDto.getMid()))
                .effectiveDate(nbpCurrencyDto.getEffectiveDate())
                .build();
    }
}
