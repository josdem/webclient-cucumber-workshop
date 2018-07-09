package com.jos.dem.webclient.service;

import reactor.core.publisher.Mono;
import com.jos.dem.webclient.model.LabelResponse;
import org.springframework.web.reactive.function.client.ClientResponse;

public interface LabelService {

  Mono<LabelResponse> create();
  Mono<ClientResponse> update(String name);
  Mono<ClientResponse> delete(String name);

}
