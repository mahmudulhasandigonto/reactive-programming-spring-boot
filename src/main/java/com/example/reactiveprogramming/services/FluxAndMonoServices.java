package com.example.reactiveprogramming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class FluxAndMonoServices {

    public Flux<String> fruitsFlux(){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"));
    }

    public Mono<String> fruitMono(){
        return Mono.just("Mango").log();
    }

    public Flux<String> fruitsFluxMap(){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .map(String::toUpperCase);
    }

    public Flux<String> fruitsFluxFilter(int number){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .filter(s -> s.length() > number);
    }


    public Flux<String> fruitsFluxFilterMap(int number){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .filter(s -> s.length() > number)
                .map(String::toUpperCase);
    }



    public static void main(String[] args) {




        FluxAndMonoServices fluxAndMonoServices
                = new FluxAndMonoServices();

        fluxAndMonoServices.fruitsFluxMap().subscribe(s -> {
            System.out.println(s);
        });







        fluxAndMonoServices.fruitsFlux().subscribe(s -> {
            System.out.println(s);
        });

        fluxAndMonoServices.fruitMono().subscribe(s -> {
            System.out.println(s);
        });
    }
}
