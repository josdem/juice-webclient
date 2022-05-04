package com.josdem.jugoterapia.webclient;

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
public class CategoryServiceJsonTest {

  private final CategoryService categoryService;
  private final DataProperties dataProperties;

  @Test
  @DisplayName("it gets categories as json")
  void shouldGetCategoriesAsJson(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());
    Mono<List<String>> publisher =
        categoryService.getCategoriesByLanguageJson("en").map(it -> it.findValuesAsText("id"));
    StepVerifier.create(publisher).expectNext(dataProperties.getCategoriesIds()).verifyComplete();
  }
}
