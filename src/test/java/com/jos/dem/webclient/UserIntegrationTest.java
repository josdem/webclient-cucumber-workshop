package com.jos.dem.webclient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import com.jos.dem.webclient.service.GitHubService;

@ContextConfiguration(classes = WebClientApplication.class)
@WebAppConfiguration
public class UserIntegrationTest {

  @Autowired
  private GitHubService gitHubService;

  @Test
  @DisplayName("Should get user keys")
  void shouldGetUserKeys() {
    assertEquals(3,
      gitHubService.getKeys()
      .collectList().block()
      .size(), () -> "Sum should be 3 keys");
  }

}
