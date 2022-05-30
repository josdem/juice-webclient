package com.josdem.jugoterapia.webclient.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.josdem.jugoterapia.webclient.model.Beverage;
import java.util.Map;
import reactor.core.publisher.Mono;

public interface BeverageService {

  Mono<Beverage> getBeverage(Integer id);

  Mono<JsonNode> getBeverageAsJson(Integer id);

  Mono<Map> getBeverageAsMap(Integer id);
}
