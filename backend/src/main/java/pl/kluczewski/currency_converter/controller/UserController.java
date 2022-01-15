package pl.kluczewski.currency_converter.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import pl.kluczewski.currency_converter.model.UserDto;
import pl.kluczewski.currency_converter.model.entity.Customer;
import pl.kluczewski.currency_converter.service.UserService;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final ModelMapper mapper;

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        UserDto userUpdated = userService.update(id, mapper.map(user, Customer.class));
        return userService.update(id, mapper.map(userUpdated, Customer.class));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
