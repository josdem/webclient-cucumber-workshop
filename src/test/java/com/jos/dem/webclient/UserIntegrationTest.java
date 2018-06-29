package com.jos.dem.webclient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import com.jos.dem.webclient.model.SSHKey;
import com.jos.dem.webclient.model.PublicEmail;
import com.jos.dem.webclient.service.GitHubService;

import reactor.core.publisher.Flux;

@ContextConfiguration(classes = WebClientApplication.class)
@WebAppConfiguration
public class UserIntegrationTest {

  @Autowired
  private GitHubService gitHubService;

  Flux<SSHKey> getKeys() throws Exception {
    return gitHubService.getKeys();
  }

  Flux<PublicEmail> getEmails() throws Exception {
    return gitHubService.getEmails();
  }

}
