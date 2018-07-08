package com.jos.dem.webclient.util;

import org.springframework.stereotype.Component;
import com.jos.dem.webclient.model.Label;

@Component
public class LabelCreator{

  private Label label = new Label("cucumber", "Cucumber is a very powerful testing framework written in the Ruby programming language","ed14c5");

  public Label create(){
    return label;
  }

}
