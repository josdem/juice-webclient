package com.josdem.jugoterapia.webclient.service.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import com.josdem.jugoterapia.webclient.model.Category;
import com.josdem.jugoterapia.webclient.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final WebClient juiceWebClient;

  @Override
  public Flux<Category> getCategoriesByLanguage(String language) {
    return juiceWebClient
        .get()
        .uri("/categories/{language}", language)
        .accept(APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(Category.class);
  }
}
