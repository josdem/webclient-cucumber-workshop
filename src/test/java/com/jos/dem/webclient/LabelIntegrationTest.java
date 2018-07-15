package com.jos.dem.webclient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.reactive.function.client.ClientResponse;

import com.jos.dem.webclient.model.LabelResponse;
import com.jos.dem.webclient.service.LabelService;

import reactor.core.publisher.Mono;

@ContextConfiguration(classes = WebClientApplication.class)
@WebAppConfiguration
public class LabelIntegrationTest {

  @Autowired
  private LabelService labelService;

  Mono<LabelResponse> create() throws Exception {
    return labelService.create();
  }

  Mono<ClientResponse> update(String name) throws Exception {
    return labelService.update(name);
  }

  Mono<ClientResponse> delete(String name) throws Exception {
    return labelService.delete(name);
  }

}
