package com.josdem.jugoterapia.webclient.service.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.josdem.jugoterapia.webclient.model.Beverage;
import com.josdem.jugoterapia.webclient.model.Category;
import com.josdem.jugoterapia.webclient.service.CategoryService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  public static final String CATEGORIES_ENDPOINT = "/categories/{language}";
  public static final String BEVERAGES_BY_CATEGORY_ENDPOINT = "/categories/{category}/beverages";
  private final WebClient juiceWebClient;

  @Override
  public Flux<Category> getCategoriesByLanguage(String language) {
    return juiceWebClient
        .get()
        .uri(CATEGORIES_ENDPOINT, language)
        .accept(APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(Category.class);
  }

  public Mono<JsonNode> getCategoriesByLanguageJson(String language) {
    return juiceWebClient
        .get()
        .uri(CATEGORIES_ENDPOINT, language)
        .accept(APPLICATION_JSON)
        .retrieve()
        .bodyToMono(JsonNode.class);
  }

  public Flux<Map> getCategoriesByLanguageMap(String language) {
    return juiceWebClient
        .get()
        .uri(CATEGORIES_ENDPOINT, language)
        .accept(APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(Map.class);
  }

  @Override
  public Flux<Beverage> getBeveragesByCategory(int category) {
    return juiceWebClient
        .get()
        .uri(BEVERAGES_BY_CATEGORY_ENDPOINT, category)
        .accept(APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(Beverage.class);
  }

  @Override
  public Mono<JsonNode> getBeveragesByCategoryJson(int category) {
    return juiceWebClient
        .get()
        .uri(BEVERAGES_BY_CATEGORY_ENDPOINT, category)
        .accept(APPLICATION_JSON)
        .retrieve()
        .bodyToMono(JsonNode.class);
  }

  @Override
  public Flux<Map> getBeveragesByCategoryMap(int category) {
    return juiceWebClient
        .get()
        .uri(BEVERAGES_BY_CATEGORY_ENDPOINT, category)
        .accept(APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(Map.class);
  }
}
