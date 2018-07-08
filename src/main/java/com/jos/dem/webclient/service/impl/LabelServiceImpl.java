package com.jos.dem.webclient.service.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

import com.jos.dem.webclient.model.Label;
import com.jos.dem.webclient.model.LabelResponse;
import com.jos.dem.webclient.service.LabelService;
import com.jos.dem.webclient.util.LabelCreator;

@Service
public class LabelServiceImpl implements LabelService {

  @Autowired
  private WebClient webClient;
  @Autowired
  private LabelCreator labelCreator;

  public Mono<LabelResponse> create() {
    return webClient.post()
      .uri("/repos/josdem/webclient-workshop/labels").accept(APPLICATION_JSON)
      .body(Mono.just(labelCreator.create()), Label.class)
      .retrieve()
      .bodyToMono(LabelResponse.class);
  }

  public Mono<ClientResponse> update(String name){
    return webClient.patch()
      .uri("/repos/josdem/webclient-workshop/labels/" + name).accept(APPLICATION_JSON)
      .body(Mono.just(labelCreator.update()), Label.class)
      .exchange();
  }

}
