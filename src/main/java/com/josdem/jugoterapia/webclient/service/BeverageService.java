package com.josdem.jugoterapia.webclient.service;

import com.josdem.jugoterapia.webclient.model.Beverage;
import reactor.core.publisher.Mono;

public interface BeverageService {

  Mono<Beverage> getBeverage(Long id);
}
