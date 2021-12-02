package pl.kluczewski.currency_converter.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConverterHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userEmail;
    private String fromCurrencyCode;
    private String toCurrencyCode;
    private BigDecimal startValue;
    private BigDecimal convertedValue;
    private LocalDateTime timeStamp;
}
