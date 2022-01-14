package pl.kluczewski.currency_converter.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Convert {
    public BigDecimal fromPln(BigDecimal quantity, BigDecimal bid) {

        return quantity.divide(bid, 2 ,RoundingMode.HALF_UP);
    }

    public BigDecimal toPln(BigDecimal quantity, BigDecimal bid) {
        return quantity.multiply(bid).setScale(2, RoundingMode.HALF_UP);

    }
}
