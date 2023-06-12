package ch.hallo02.springandco.webfluxsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.Arrays;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        var appCtx = SpringApplication.run(Main.class, args);

    }
}