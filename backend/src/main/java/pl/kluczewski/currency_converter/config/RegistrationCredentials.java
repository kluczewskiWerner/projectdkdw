package pl.kluczewski.currency_converter.config;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationCredentials {
    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;
}
