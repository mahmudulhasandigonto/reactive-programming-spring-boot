package com.example.reactiveprogramming.services;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoServicesTest {

    FluxAndMonoServices fluxAndMonoServices
            = new FluxAndMonoServices();

    @Test
    void fruitsFlux() {
      Flux<String> fruitsFlux=  fluxAndMonoServices.fruitsFlux();

        StepVerifier.create(fruitsFlux)
                .expectNext("Mango", "Orange", "Banana")
                .verifyComplete();
    }

    @Test
    void fruitMono() {
        Mono<String> fruitsMono = fluxAndMonoServices.fruitMono();

        StepVerifier.create(fruitsMono)
                .expectNext("Mango")
                .verifyComplete();

    }


    @Test
    void fruitsFluxMap() {
        Flux<String> fruitsFlux=  fluxAndMonoServices.fruitsFluxMap();

        StepVerifier.create(fruitsFlux)
                .expectNext("MANGO", "ORANGE", "BANANA")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFilter() {
        Flux<String> stringFlux = fluxAndMonoServices.fruitsFluxFilter(5);

        StepVerifier.create(stringFlux)
                .expectNext("Orange", "Banana")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFilterMap() {
        Flux<String> stringFlux = fluxAndMonoServices.fruitsFluxFilterMap(5);
        StepVerifier.create(stringFlux)
                .expectNext("ORANGE", "BANANA")
                .verifyComplete();
    }
}