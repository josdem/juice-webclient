package com.josdem.jugoterapia.webclient;

import com.fasterxml.jackson.databind.JsonNode;
import com.josdem.jugoterapia.webclient.config.DataProperties;
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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.assertAll;

@Slf4j
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class BeverageServiceHamcrestTest {
  private final BeverageService beverageService;
  private final DataProperties dataProperties;

  @Test
  @DisplayName("it gets beverage as json")
  void shouldValidateBeverageWithHamcrest(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());
    Mono<JsonNode> publisher = beverageService.getBeverageAsJson(85);
    StepVerifier.create(publisher)
        .assertNext(
            beverage -> {
              assertAll(
                  "beverage",
                  () ->
                          assertThat(dataProperties.getBeverage().getId(), is(beverage.get("id").asInt()))
                  );
            })
        .verifyComplete();
  }
}
