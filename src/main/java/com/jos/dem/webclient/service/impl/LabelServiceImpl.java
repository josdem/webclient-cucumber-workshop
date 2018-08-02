package com.jos.dem.webclient.service.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

import com.jos.dem.webclient.model.LabelResponse;
import com.jos.dem.webclient.service.LabelService;
import com.jos.dem.webclient.util.LabelCreator;

@Service
public class LabelServiceImpl implements LabelService {

  @Autowired
  private WebClient webClient;
  @Autowired
  private LabelCreator labelCreator;

  @Value("${github.labels.path}")
  private String githubLabelsPath;

  public Mono<LabelResponse> create() {
    return webClient.post()
      .uri(githubLabelsPath).accept(APPLICATION_JSON)
      .body(BodyInserters.fromObject(labelCreator.create()))
      .retrieve()
      .bodyToMono(LabelResponse.class);
  }

  public Mono<ClientResponse> update(String name){
    return webClient.patch()
      .uri(githubLabelsPath + "/" + name).accept(APPLICATION_JSON)
      .body(BodyInserters.fromObject(labelCreator.update()))
      .exchange();
  }

  public Mono<ClientResponse> delete(String name){
    return webClient.delete()
      .uri(githubLabelsPath + "/" + name).accept(APPLICATION_JSON)
      .exchange();
  }

}
