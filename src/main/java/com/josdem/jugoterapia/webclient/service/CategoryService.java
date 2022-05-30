package com.josdem.jugoterapia.webclient.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.josdem.jugoterapia.webclient.model.Beverage;
import com.josdem.jugoterapia.webclient.model.Category;
import java.util.Map;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryService {
  Flux<Category> getCategoriesByLanguage(String language);

  Mono<JsonNode> getCategoriesByLanguageJson(String language);

  Flux<Map> getCategoriesByLanguageMap(String language);

  Flux<Beverage> getBeveragesByCategory(int category);

  Mono<JsonNode> getBeveragesByCategoryJson(int category);

  Flux<Map> getBeveragesByCategoryMap(int category);
}
