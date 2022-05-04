package com.josdem.jugoterapia.webclient.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.josdem.jugoterapia.webclient.model.Beverage;
import reactor.core.publisher.Mono;

public interface BeverageService {

  Mono<Beverage> getBeverage(Long id);

  Mono<JsonNode> getBeverageAsJson(Long id);
}
