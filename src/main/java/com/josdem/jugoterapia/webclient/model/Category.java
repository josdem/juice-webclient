package com.josdem.jugoterapia.webclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
  private Integer id;
  private String name;
  private String i18n;
}
