package com.jos.dem.webclient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import com.jos.dem.webclient.model.SSHKey;
import com.jos.dem.webclient.model.PublicEmail;
import com.jos.dem.webclient.service.GitHubService;

@Service
public class GitHubServiceImpl implements GitHubService {

  @Autowired
  private WebClient webClient;

  public Flux<SSHKey> getKeys() {
    return webClient.get().uri("/josdem/keys").retrieve()
    .bodyToFlux(SSHKey.class);
  }

  public Flux<PublicEmail> getEmails() {
    return webClient.get().uri("/public_emails").retrieve()
    .bodyToFlux(PublicEmail.class);
  }

}
