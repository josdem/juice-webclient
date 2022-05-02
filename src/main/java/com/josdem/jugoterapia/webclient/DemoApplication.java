package com.josdem.jugoterapia.webclient;

import com.josdem.jugoterapia.webclient.service.BeverageService;
import com.josdem.jugoterapia.webclient.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  CommandLineRunner run(CategoryService categoryService, BeverageService beverageService) {
    return args -> {
      log.info("Displaying categories");
      categoryService
          .getCategoriesByLanguage("en")
          .subscribe(category -> log.info(category.toString()));
      log.info("Displaying beverage by id");
      beverageService.getBeverage(35L).subscribe(beverage -> log.info(beverage.toString()));
    };
  }
}
