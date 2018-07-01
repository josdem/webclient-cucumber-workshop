package com.jos.dem.webclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Label {
  private String name;
  private String description;
  private String color;
}
