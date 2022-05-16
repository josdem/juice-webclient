package com.josdem.jugoterapia.webclient.service.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.josdem.jugoterapia.webclient.model.Beverage;
import com.josdem.jugoterapia.webclient.service.BeverageService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BeverageServiceImpl implements BeverageService {

  public static final String BEVERAGES_ENDPOINT = "/beverages/{id}";
  private final WebClient juiceWebClient;

  public Mono<Beverage> getBeverage(Integer id) {
    return juiceWebClient
        .get()
        .uri(BEVERAGES_ENDPOINT, id)
        .accept(APPLICATION_JSON)
        .retrieve()
        .bodyToMono(Beverage.class);
  }

  public Mono<JsonNode> getBeverageAsJson(Integer id) {
    return juiceWebClient
        .get()
        .uri("/beverages/{id}", id)
        .accept(APPLICATION_JSON)
        .retrieve()
        .bodyToMono(JsonNode.class);
  }

  public Mono<Map> getBeverageAsMap(Integer id) {
    return juiceWebClient
        .get()
        .uri("/beverages/{id}", id)
        .accept(APPLICATION_JSON)
        .retrieve()
        .bodyToMono(Map.class);
  }
}
