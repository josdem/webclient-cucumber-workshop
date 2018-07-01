package com.jos.dem.webclient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import com.jos.dem.webclient.model.Label;
import com.jos.dem.webclient.model.LabelResponse;
import com.jos.dem.webclient.service.LabelService;

@Service
public class LabelServiceImpl implements LabelService {

  @Autowired
  private WebClient webClient;

  private Label label;

  @PostConstruct
  public void setup(){
    label = new Label("cucumber", "Cucumber is a very powerful testing framework written in the Ruby programming language","#ed14c5");
  }

  public Flux<LabelResponse> create() {
    return webClient.post()
      .uri("/repos/josdem/webclient-workshop/labels").retrieve()
      .body(LabelResponse.class);
  }

}
