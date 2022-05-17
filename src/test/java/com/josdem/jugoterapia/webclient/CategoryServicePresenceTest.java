package com.josdem.jugoterapia.webclient;

import com.josdem.jugoterapia.webclient.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

@Slf4j
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CategoryServicePresenceTest {

  private final CategoryService categoryService;

  @Test
  @DisplayName("it validates Energy category with id 6 exist")
  void shouldGetCategories(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());
    StepVerifier.create(
            categoryService.getCategoriesByLanguage("en").filter(category -> category.getId() == 6))
        .expectNextCount(1)
        .verifyComplete();
  }
}
