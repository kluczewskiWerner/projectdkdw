package pl.kluczewski.currency_converter.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConverterHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String fromCurrencyCode;
    private String toCurrencyCode;
    private BigDecimal startValue;
    private BigDecimal convertedValue;
    private LocalDateTime timeStamp;
}
