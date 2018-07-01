package com.jos.dem.webclient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import com.jos.dem.webclient.model.LabelResponse;
import com.jos.dem.webclient.service.LabelService;

import reactor.core.publisher.Flux;

@ContextConfiguration(classes = WebClientApplication.class)
@WebAppConfiguration
public class UserIntegrationTest {

  @Autowired
  private LabelService labelService;

  Flux<LabelResponse> create() throws Exception {
    return labelService.create();
  }

}
