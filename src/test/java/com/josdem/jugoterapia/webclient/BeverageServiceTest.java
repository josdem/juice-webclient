package com.josdem.jugoterapia.webclient;

import com.josdem.jugoterapia.webclient.config.DataProperties;
import com.josdem.jugoterapia.webclient.model.Beverage;
import com.josdem.jugoterapia.webclient.service.BeverageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class BeverageServiceTest {
  private final BeverageService beverageService;
  private final DataProperties dataProperties;

  @Test
  @DisplayName("it gets beverage by id")
  void shouldGetBeverageById(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());
    Mono<Beverage> publisher = beverageService.getBeverage(85);
    StepVerifier.create(publisher).expectNext(dataProperties.getBeverage()).verifyComplete();
  }
}
