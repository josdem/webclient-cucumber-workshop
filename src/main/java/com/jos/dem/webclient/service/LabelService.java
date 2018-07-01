package com.jos.dem.webclient.service;

import reactor.core.publisher.Mono;
import com.jos.dem.webclient.model.LabelResponse;

public interface LabelService {

  Mono<LabelResponse> create();

}
