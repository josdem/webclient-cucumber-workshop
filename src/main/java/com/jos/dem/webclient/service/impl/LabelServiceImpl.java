package com.jos.dem.webclient.service.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

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
    label = new Label("cucumber", "Cucumber is a very powerful testing framework written in the Ruby programming language","ed14c5");
  }

  public Mono<LabelResponse> create() {
    return webClient.post()
      .uri("/repos/josdem/webclient-workshop/labels").accept(APPLICATION_JSON)
      .body(Mono.just(label), Label.class)
      .retrieve()
      .bodyToMono(LabelResponse.class);
  }

}
