package pl.kluczewski.currency_converter.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {

    private Convert convert;
    private BigDecimal quantity, bid;

    @BeforeEach
    public void setUp() {
        convert = new Convert();
        quantity = BigDecimal.valueOf(1500);
        bid = BigDecimal.valueOf(4.1355);
    }

    @Test
    public void fromPln() {
       assertEquals(BigDecimal.valueOf(362.71), convert.fromPln(quantity, bid));
    }

    @Test
    public void toPln() {
        assertEquals(BigDecimal.valueOf(6203.25), convert.toPln(quantity, bid));
    }
}