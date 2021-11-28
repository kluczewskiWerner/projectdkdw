package pl.kluczewski.currency_converter.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kluczewski.currency_converter.model.entity.User;
import pl.kluczewski.currency_converter.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with email %s not found";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public void singUpUser(User user) {
        boolean userExist = userRepository.findByEmail(user.getUsername())
                .isPresent();

        if(userExist) {
            throw new IllegalStateException("Email taken");
        }

        String encodedPassWord = bCryptPasswordEncoder
                .encode(user.getPassword());

        user.setPassword(encodedPassWord);

        userRepository.save(user);

        //TODO: send confirmation token
    }
}
