package com.josdem.jugoterapia.webclient;

import com.josdem.jugoterapia.webclient.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CategoryServiceTest {

  private final CategoryService categoryService;

  @Test
  @DisplayName("it gets categories")
  void shouldGetCategories() {
    StepVerifier.create(categoryService.getCategoriesByLanguage("en"))
        .expectNextCount(4)
        .verifyComplete();
  }
}
