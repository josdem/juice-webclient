package com.josdem.jugoterapia.webclient.service.impl;

import com.josdem.jugoterapia.webclient.model.Beverage;
import com.josdem.jugoterapia.webclient.service.BeverageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@RequiredArgsConstructor
public class BeverageServiceImpl implements BeverageService {

    private final WebClient juiceWebClient;

    public Mono<Beverage> getBeverage(Long id) {
        return juiceWebClient.get()
                .uri("/beverages/{id}", id).accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Beverage.class);
    }

}
