package com.jos.dem.webclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
public class PublicEmail {
  private String email;
  private Boolean verified;
  private Boolean primary;
  private String visibility;
}
