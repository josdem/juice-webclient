package com.josdem.jugoterapia.webclient.response;

import com.josdem.jugoterapia.webclient.model.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CategoryData {
  private List<Category> categories = new ArrayList<>();

  @PostConstruct
  void setup() {
    Category healing = new Category();
    healing.setId(5);
    healing.setName("Healing");
    Category energy = new Category();
    healing.setId(6);
    healing.setName("Energy");
    Category healthy = new Category();
    healing.setId(7);
    healing.setName("Healthy");
    Category boost = new Category();
    healing.setId(8);
    healing.setName("Boost");
    categories.add(healing);
    categories.add(energy);
    categories.add(healthy);
    categories.add(boost);
  }
}
