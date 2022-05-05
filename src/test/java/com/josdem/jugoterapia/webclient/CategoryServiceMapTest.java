package com.josdem.jugoterapia.webclient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.josdem.jugoterapia.webclient.config.DataProperties;
import com.josdem.jugoterapia.webclient.service.CategoryService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CategoryServiceMapTest {

  private final CategoryService categoryService;
  private final DataProperties dataProperties;

  @Test
  @DisplayName("it gets categories ids as map")
  void shouldValidateCategoriesIds(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());
    Flux<Map> publisher = categoryService.getCategoriesByLanguageMap("en");
    StepVerifier.create(publisher)
        .assertNext(
            category -> {
              assertEquals(dataProperties.getCategories().get(0).getId(), category.get("id"));
              assertEquals(dataProperties.getCategories().get(0).getName(), category.get("name"));
            })
        .assertNext(
            category -> {
              assertEquals(dataProperties.getCategories().get(1).getId(), category.get("id"));
              assertEquals(dataProperties.getCategories().get(1).getName(), category.get("name"));
            })
        .assertNext(
            category -> {
              assertEquals(dataProperties.getCategories().get(2).getId(), category.get("id"));
              assertEquals(dataProperties.getCategories().get(2).getName(), category.get("name"));
            })
        .assertNext(
            category -> {
              assertEquals(dataProperties.getCategories().get(3).getId(), category.get("id"));
              assertEquals(dataProperties.getCategories().get(3).getName(), category.get("name"));
            })
        .verifyComplete();
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
}
