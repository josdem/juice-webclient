package com.josdem.jugoterapia.webclient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.josdem.jugoterapia.webclient.config.DataProperties;
import com.josdem.jugoterapia.webclient.service.CategoryService;
import java.util.List;
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
class CategoryServiceJsonTest {

  private final CategoryService categoryService;
  private final DataProperties dataProperties;

  @Test
  @DisplayName("it gets categories ids as json")
  void shouldValidateCategoriesIds(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());
    Mono<List<String>> publisher =
        categoryService.getCategoriesByLanguageJson("en").map(it -> it.findValuesAsText("id"));
    StepVerifier.create(publisher).expectNext(dataProperties.getCategoriesIds()).verifyComplete();
  }

  @Test
  @DisplayName("it gets categories values as json")
  void shouldGetCategoriesValues(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());
    Mono<List<String>> publisher =
        categoryService.getCategoriesByLanguageJson("en").map(it -> it.findValuesAsText("name"));
    StepVerifier.create(publisher)
        .expectNext(dataProperties.getCategoriesValues())
        .verifyComplete();
  }

  @Test
  @DisplayName("it gets beverages by category as json")
  void shouldGetBeveragesByCategory(TestInfo testInfo) {
    log.info("Running {}", testInfo.getDisplayName());
    Mono<List<String>> publisher =
        categoryService.getBeveragesByCategoryJson(5).map(it -> it.findValuesAsText("id"));
    StepVerifier.create(publisher)
        .assertNext(
            beverages -> {
              assertEquals(13, beverages.size(), "should be 13 healthy beverages");
            })
        .verifyComplete();
  }
}
