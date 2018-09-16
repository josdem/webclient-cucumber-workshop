package com.jos.dem.webclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabelResponse {
  private Long id;

  @JsonProperty("node_id")
  private String nodeId;

  private String url;
  private String name;
  private String color;

  @JsonProperty("default")
  private boolean status;
}
