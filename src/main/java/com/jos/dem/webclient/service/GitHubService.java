package com.jos.dem.webclient.service;

import reactor.core.publisher.Flux;
import com.jos.dem.webclient.model.SSHKey;
import com.jos.dem.webclient.model.PublicEmail;

public interface GitHubService {

  Flux<SSHKey> getKeys();
  Flux<PublicEmail> getEmails();

}
