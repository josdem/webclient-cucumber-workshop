package com.jos.dem.webclient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import com.jos.dem.webclient.model.LabelResponse;
import com.jos.dem.webclient.service.LabelService;

@Service
public class LabelServiceImpl implements LabelService {

  @Autowired
  private WebClient webClient;

  public Flux<LabelResponse> create() {
    return webClient.get().uri("").retrieve()
    .bodyToFlux(LabelResponse.class);
  }

}
