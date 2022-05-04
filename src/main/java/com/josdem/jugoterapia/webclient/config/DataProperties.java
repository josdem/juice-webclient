package com.josdem.jugoterapia.webclient.config;

import com.josdem.jugoterapia.webclient.model.Beverage;
import com.josdem.jugoterapia.webclient.model.Category;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("data")
public class DataProperties {
  private Beverage beverage;
  private List<Category> categories;
  private List<String> categoriesIds;
  private List<String> categoriesValues;
}
