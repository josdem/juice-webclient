package com.josdem.jugoterapia.webclient.service.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import com.josdem.jugoterapia.webclient.config.ApplicationProperties;
import com.josdem.jugoterapia.webclient.model.Beverage;
import com.josdem.jugoterapia.webclient.service.BeverageService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class BeverageServiceImpl implements BeverageService {

    private final ApplicationProperties applicationProperties;
    private WebClient webClient;

    @PostConstruct
    void setup(){
        webClient = WebClient.create(applicationProperties.getUrl());
    }

    public Mono<Beverage> getBeverage(Long id){
        return webClient.get()
                .uri("/beverages/{id}", id).accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Beverage.class);
    }

}
