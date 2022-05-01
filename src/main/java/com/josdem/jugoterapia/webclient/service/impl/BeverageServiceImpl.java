package com.josdem.jugoterapia.webclient.service.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import com.josdem.jugoterapia.webclient.model.Beverage;
import com.josdem.jugoterapia.webclient.service.BeverageService;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BeverageServiceImpl implements BeverageService {

    private WebClient client = WebClient.create("https://webflux.josdem.io");

    public Mono<Beverage> getBeverage(Long id){
        return client.get()
                .uri("/beverages/{id}", id).accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Beverage.class);
    }

}
