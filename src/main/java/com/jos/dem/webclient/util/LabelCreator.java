package com.jos.dem.webclient.util;

import org.springframework.stereotype.Component;
import com.jos.dem.webclient.model.Label;

@Component
public class LabelCreator{

  private Label label = new Label("cucumber", "Cucumber is a very powerful testing framework written in the Ruby programming language","ed14c5");

  public Label create(){
    return label;
  }

  public Label update(){
    label.setName("spock");
    label.setDescription("Spock is a testing and specification framework for Java and Groovy applications. It is beautiful and highly expressive");
    label.setColor("ff0000");
    return label;
  }

}
