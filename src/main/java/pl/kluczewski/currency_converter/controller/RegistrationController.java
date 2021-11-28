package pl.kluczewski.currency_converter.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kluczewski.currency_converter.config.RegistrationCredentials;
import pl.kluczewski.currency_converter.service.RegistrationService;

@RestController
@CrossOrigin
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public void register(@RequestBody RegistrationCredentials request) {
        registrationService.register(request);
    }
}
