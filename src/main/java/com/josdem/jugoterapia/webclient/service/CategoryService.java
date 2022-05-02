package com.josdem.jugoterapia.webclient.service;

import com.josdem.jugoterapia.webclient.model.Category;
import reactor.core.publisher.Flux;

public interface CategoryService {
  Flux<Category> getCategoriesByLanguage(String language);
}
