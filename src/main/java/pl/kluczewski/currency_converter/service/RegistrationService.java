package pl.kluczewski.currency_converter.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kluczewski.currency_converter.config.RegistrationCredentials;
import pl.kluczewski.currency_converter.model.entity.User;
import pl.kluczewski.currency_converter.model.entity.UserRole;
import pl.kluczewski.currency_converter.validator.EmailValidator;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;

    public void register(RegistrationCredentials request) {

        boolean isValidEmail = emailValidator.test(request.getEmail());

        if(!isValidEmail) {
            throw new IllegalStateException("Email not valid");
        }

        userService.singUpUser(new User(
                request.getEmail(),
                request.getPassword(),
                UserRole.USER
        ));
    }
}
