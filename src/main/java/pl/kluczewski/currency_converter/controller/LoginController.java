package pl.kluczewski.currency_converter.controller;

import org.springframework.web.bind.annotation.*;
import pl.kluczewski.currency_converter.config.LoginCredentials;

@CrossOrigin
@RestController
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials credentials) {}

    @GetMapping("/secured")
    public String secured() {
        return "secured";
    }
}
