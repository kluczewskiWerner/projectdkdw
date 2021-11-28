package pl.kluczewski.currency_converter.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {
    private Date date;
    private String message;
    private int statusCode;
}
