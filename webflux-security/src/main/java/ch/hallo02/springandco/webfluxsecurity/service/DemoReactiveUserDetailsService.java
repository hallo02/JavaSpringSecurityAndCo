package ch.hallo02.springandco.webfluxsecurity.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;

import java.util.List;

public class DemoReactiveUserDetailsService implements ReactiveUserDetailsService {

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return Mono.just(getUser(username));
    }

    private static UserDetails getUser(String username) {
        return switch (username) {
            case "user" -> getUserDetails("user", "password", "user");
            case "admin" -> getUserDetails("admin", "password", "admin");
            default -> getUserDetails("unknown", "");
        };
    }

    private static UserDetails getUserDetails(String username, String password, String... roles) {
        return User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles(roles)
                .build();
    }
}
