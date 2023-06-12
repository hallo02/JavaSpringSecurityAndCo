package ch.hallo02.springandco.webfluxsecurity.configuration;

import ch.hallo02.springandco.webfluxsecurity.service.DemoReactiveAuthenticationManager;
import ch.hallo02.springandco.webfluxsecurity.service.DemoReactiveUserDetailsService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.WebFilterChainProxy;
import org.springframework.stereotype.Component;

@Configuration
public class SecurityConfiguration {

    /*
    To switch off the default web application security configuration completely,
    you can add a bean of type WebFilterChainProxy
    (doing so does not disable the UserDetailsService configuration or Actuator’s security).
     */

    //    @Bean
    //    public WebFilterChainProxy webFilterChainProxy() {
    //        return new WebFilterChainProxy();
    //    }

    /*
    To also switch off the UserDetailsService configuration,
    you can add a bean of type ReactiveUserDetailsService or
    ReactiveAuthenticationManager.
     */

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http.authorizeExchange((exchange) -> {
                    exchange
                            .pathMatchers("/protectedendpoint").hasAnyRole("user", "admin")
                            .pathMatchers("/protectedendpointadmin").authenticated()
                            .anyExchange().permitAll();

                }).httpBasic(basic -> {
                })
                .build();

    }

    /*
    If one provides a custom ReactiveAuthenticationManager then a ReactiveUserDetailsService is not needed.
    */
    @Bean
    public ReactiveUserDetailsService reactiveUserDetailsService() {
        return new DemoReactiveUserDetailsService();
    }

    /*
    The default is AbstractUserDetailsReactiveAuthenticationManager
     */
    @Bean
    public ReactiveAuthenticationManager reactiveAuthenticationManager() {
        return new DemoReactiveAuthenticationManager();
    }

}
