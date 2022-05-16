package com.josdem.jugoterapia.webclient;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

@Slf4j
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class BeverageServiceJsonTest {
  private final BeverageService beverageService;
  private final DataProperties dataProperties;

  @Test
  @DisplayName("it gets beverage as json")
  void shouldValidateBeverageAsJson(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());
    Mono<JsonNode> publisher = beverageService.getBeverageAsJson(85);
    StepVerifier.create(publisher)
        .assertNext(
            beverage -> {
              assertAll(
                  "beverage",
                  () ->
                      assertEquals(
                          dataProperties.getBeverage().getId(), beverage.get("id").asInt()),
                  () ->
                      assertEquals(
                          dataProperties.getBeverage().getName(), beverage.get("name").asText()),
                  () ->
                      assertEquals(
                          dataProperties.getBeverage().getIngredients(),
                          beverage.get("ingredients").asText()),
                  () ->
                      assertEquals(
                          dataProperties.getBeverage().getRecipe(),
                          beverage.get("recipe").asText()),
                  () ->
                      assertEquals(
                          dataProperties.getBeverage().getImage(), beverage.get("image").asText()));
            })
        .verifyComplete();
  }
}
