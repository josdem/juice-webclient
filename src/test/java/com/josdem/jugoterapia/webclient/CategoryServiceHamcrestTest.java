package com.josdem.jugoterapia.webclient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
class CategoryServiceHamcrestTest {

  private final CategoryService categoryService;
  private final DataProperties dataProperties;

  @Test
  @DisplayName("it gets categories ids as json")
  void shouldValidateCategoriesIds(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());
    Mono<List<String>> publisher =
        categoryService.getCategoriesByLanguageJson("en").map(it -> it.findValuesAsText("id"));
    StepVerifier.create(publisher)
        .assertNext(ids -> assertThat(ids, equalTo(dataProperties.getCategoriesIds())))
        .verifyComplete();
  }

  @Test
  @DisplayName("it gets categories values as json")
  void shouldGetCategoriesValues(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());
    Mono<List<String>> publisher =
        categoryService.getCategoriesByLanguageJson("en").map(it -> it.findValuesAsText("name"));
    StepVerifier.create(publisher)
        .assertNext(ids -> assertThat(ids, equalTo(dataProperties.getCategoriesValues())))
        .verifyComplete();
  }
}
