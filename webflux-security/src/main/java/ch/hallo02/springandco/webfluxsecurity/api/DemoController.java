package ch.hallo02.springandco.webfluxsecurity.api;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class DemoController {

    public DemoController() {
        System.out.print("Got init");
    }

    @GetMapping("openendpoint")
    public Mono<String> openEndpoint() {
        return Mono.just("This is an open endpoint");
    }

    @GetMapping("protectedendpoint")
    public Mono<String> protectedEndpoint(Principal principal) {
        return Mono.just("""
                This is a protected endpoint. Name %s
                """
                .formatted(principal.getName()));
    }

    @GetMapping("protectedendpointadmin")
    public Mono<String> protectedEndpointAdmin(Principal principal) {
        return Mono.just("""
                This is a protected endpoint. Name %s
                """
                .formatted(principal.getName()));
    }

}
