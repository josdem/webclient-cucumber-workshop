package com.jos.dem.webclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelResponse {
  private Long id;
  private String nodeId;
  private String url;
  private String name;
  private String description;
  private String color;,
  private boolean default;
}
