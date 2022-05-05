package com.josdem.jugoterapia.webclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Beverage {

  private Integer id;
  private String name;
  private String ingredients;
  private String recipe;
  private String image;
}
