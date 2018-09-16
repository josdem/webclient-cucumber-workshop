package com.jos.dem.webclient.model;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Label {
  private String name;
  private String description;
  private String color;
}
