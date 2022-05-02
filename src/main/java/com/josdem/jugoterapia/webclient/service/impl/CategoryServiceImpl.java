package com.josdem.jugoterapia.webclient.service.impl;

import com.josdem.jugoterapia.webclient.config.ApplicationProperties;
import com.josdem.jugoterapia.webclient.model.Category;
import com.josdem.jugoterapia.webclient.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final ApplicationProperties applicationProperties;
    private WebClient webClient;

    @PostConstruct
    void setup() {
        webClient = WebClient.create(applicationProperties.getUrl());
    }

    @Override
    public Flux<Category> getCategoriesByLanguage(String language) {
        return webClient.get()
                .uri("/categories/{language}", language).accept(APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Category.class);
    }
}
