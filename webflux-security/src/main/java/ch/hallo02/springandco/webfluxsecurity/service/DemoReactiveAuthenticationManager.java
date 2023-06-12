package ch.hallo02.springandco.webfluxsecurity.service;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import reactor.core.publisher.Mono;

public class DemoReactiveAuthenticationManager implements ReactiveAuthenticationManager {

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return Mono.just(
                UsernamePasswordAuthenticationToken.authenticated(
                        authentication.getPrincipal(),
                        authentication.getCredentials(),
                        authentication.getAuthorities()
                )
        );
    }
}
