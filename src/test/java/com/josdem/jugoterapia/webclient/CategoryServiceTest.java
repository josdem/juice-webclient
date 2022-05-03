package com.josdem.jugoterapia.webclient;

import com.josdem.jugoterapia.webclient.response.CategoryData;
import com.josdem.jugoterapia.webclient.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CategoryServiceTest {

  private final CategoryService categoryService;
  private final CategoryData categoryData;

  @Test
  @DisplayName("it validates categories size")
  void shouldGetCategories() {
    StepVerifier.create(categoryService.getCategoriesByLanguage("en"))
        .expectNextCount(4)
        .verifyComplete();
  }

  @Test
  @DisplayName("it validates category ids")
  void shouldValidateCategoryIds() {
    Flux<Integer> categories =
        categoryService.getCategoriesByLanguage("en").map(category -> category.getId());
    StepVerifier.create(categories).expectNext(5, 6, 7, 8).verifyComplete();
  }

  @Test
  @DisplayName("it validates category names")
  void shouldValidateCategoryNames() {
    Flux<String> categories =
        categoryService.getCategoriesByLanguage("en").map(category -> category.getName());
    StepVerifier.create(categories)
        .expectNext("Healing", "Energy", "Healthy", "Boost")
        .verifyComplete();
  }
}
